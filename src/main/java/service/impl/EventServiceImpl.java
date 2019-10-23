package service.impl;

import model.Event;
import service.EventService;

import java.time.LocalDateTime;

public class EventServiceImpl implements EventService {

    @Override
    public boolean checkOverlappingBetweenEvents(Event event1, Event event2) {
        LocalDateTime startActivity1 = event1.getStartActivity();
        LocalDateTime endActivity1 = event1.getEndActivity();
        LocalDateTime startActivity2 = event1.getEndActivity();
        LocalDateTime endActivity2 = event2.getEndActivity();

        if (startActivity1.compareTo(startActivity2) >= 0 && startActivity1.compareTo(endActivity2) <= 0)
            return true;

        return endActivity1.compareTo(startActivity2) >= 0 && endActivity1.compareTo(endActivity2) <= 0;
    }

}
