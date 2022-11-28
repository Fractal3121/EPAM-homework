package com.epam.rd.autocode.observer.git;

import java.util.*;
import java.util.stream.Collectors;

public class RepoImpl implements Repository {
    List<WebHook> webHookList;


    public RepoImpl() {
        this.webHookList = new ArrayList<>();
    }

    @Override
    public void addWebHook(WebHook webHook) {
    webHookList.add(webHook);
    }

    @Override
    public Commit commit(String branch, String author, String[] changes) {
        Commit a = new Commit(author, changes);
        List<Commit> comm = new ArrayList<>();
        comm.add(a);
        webHookList.stream().filter(webHook -> branch.equals(webHook.branch()) && webHook.type().equals(Event.Type.COMMIT))
                .findFirst().ifPresent(webHook -> webHook.onEvent(new Event(Event.Type.COMMIT, branch, comm)));
        return a;
    }

    @Override
    public void merge(String sourceBranch, String targetBranch) {
        Optional<WebHook> first2 = webHookList.stream().filter(webHook -> sourceBranch.equals(webHook.branch()) && webHook.type().equals(Event.Type.COMMIT))
                .findFirst();
        Optional<WebHook> first1 = webHookList.stream().filter(webHook -> targetBranch.equals(webHook.branch()) && webHook.type().equals(Event.Type.COMMIT))
                .findFirst();

        Optional<WebHook> first = webHookList.stream().filter(webHook -> targetBranch.equals(webHook.branch()) && webHook.type().equals(Event.Type.MERGE))
                .findFirst();
        List<Commit> commitListFirst2 = null;
        if(first2.isPresent()){
            commitListFirst2 = first2.get().caughtEvents().stream().flatMap(event -> event.commits().stream()).collect(Collectors.toList());
        }
        List<Commit> commitListFirst1 = null;
        if (first1.isPresent()){
            commitListFirst1 = first1.get().caughtEvents().stream().flatMap(event -> event.commits().stream()).collect(Collectors.toList());
        }
        if(commitListFirst2 == null) return;
        List<Commit> mergeCommits = new ArrayList<>();
        if(commitListFirst1 != null) {
            for(Commit merge : commitListFirst2){
                if(commitListFirst1.stream().noneMatch(merge::equals)){
                    mergeCommits.add(merge);
                }
            }
        }
        else {
            mergeCommits = commitListFirst2;
        }
        if (first.isPresent()){
            first.get().onEvent(new Event(Event.Type.MERGE, targetBranch, mergeCommits));
        }
    }
}
