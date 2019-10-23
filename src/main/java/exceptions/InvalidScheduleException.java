package exceptions;

import model.Event;

public class InvalidScheduleException extends Exception {

    public InvalidScheduleException(Event event1, Event event2) {
        super("Invalid schedule." + event1.getTitle() + " and " + event2.getTitle() + " are overlapping");
    }

}
