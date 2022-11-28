package com.epam.rd.autocode.observer.git;

import java.util.ArrayList;
import java.util.List;

public class WebHooksImpl implements WebHook{
    private final String branch;
    private final Event.Type type;
    private final List<Event> eventList;

    public WebHooksImpl(String branch, Event.Type type) {
        this.branch = branch;
        this.type = type;
        this.eventList = new ArrayList<>();
    }


    @Override
    public String branch() {
        return branch;
    }

    @Override
    public Event.Type type() {
        return type;
    }

    @Override
    public List<Event> caughtEvents() {
        return eventList;
    }

    @Override
    public void onEvent(Event event) {
       if(!eventList.contains(event)){
           eventList.add(event);
       }
    }
}
