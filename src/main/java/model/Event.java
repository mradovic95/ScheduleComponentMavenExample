package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


/**
 * Represents one event in user schedule.It can be work activity(for example
 * finish project for university) or fun activity(for example go to party)
 *
 * @author comex
 */

public abstract class Event {

    /**
     * The title of event
     */
    private String title;
    /**
     * description of the event
     */
    private String description;
    /**
     * event start time
     */
    private LocalDateTime startActivity;
    /**
     * event end time
     */
    private LocalDateTime endActivity;
    /**
     * is event finished successfully
     */
    private boolean done;

    /**
     * list of other person on this event
     */
    private List<Person> persons = new ArrayList<>();

    public Event() {

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


    public LocalDateTime getStartActivity() {
        return startActivity;
    }


    public void setStartActivity(LocalDateTime startActivity) {
        this.startActivity = startActivity;
    }


    public LocalDateTime getEndActivity() {
        return endActivity;
    }


    public void setEndActivity(LocalDateTime endActivity) {
        this.endActivity = endActivity;
    }


    public boolean isDone() {
        return done;
    }


    public void setDone(boolean done) {
        this.done = done;
    }


    public List<Person> getPersons() {
        return persons;
    }


    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public boolean equals(Object other) {

        if (!(other instanceof Event)) {
            return false;
        }

        Event otherEvent = (Event) other;

        return this.title.equals(otherEvent.getTitle());

    }

}
