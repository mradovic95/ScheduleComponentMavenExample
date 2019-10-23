package model;

import java.util.ArrayList;
import java.util.List;


public class Schedule {

    private String title;
    private String description;
    private List<Event> events = new ArrayList<>();

    public Schedule() {

    }

    public Schedule(String title, String description, List<Event> events) {
        super();
        this.title = title;
        this.description = description;
        this.events = events;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public boolean add(Event arg0) {
        return events.add(arg0);
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Schedule)) {
            return false;
        }

        Schedule otherEvent = (Schedule) other;

        return this.title.equals(otherEvent.getTitle());
    }


}
