package com.epam.rd.autocode.observer.git;

public class GitRepoObservers {
    public static Repository newRepository(){
        return new RepoImpl();
    }

    public static WebHook mergeToBranchWebHook(String branchName){
        return new WebHooksImpl(branchName, Event.Type.MERGE);
    }

    public static WebHook commitToBranchWebHook(String branchName){
        return new WebHooksImpl(branchName, Event.Type.COMMIT);
    }


}
