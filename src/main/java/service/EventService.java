package service;

import model.Event;

public interface EventService {

    boolean checkOverlappingBetweenEvents(Event event1, Event event2);

}
