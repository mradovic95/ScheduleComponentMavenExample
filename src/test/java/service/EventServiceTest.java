package service;

import impl.EventServiceImpl;
import model.Event;
import model.EventFactory;
import model.Schedule;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EventServiceTest {

    private EventService sut;

    public EventServiceTest() {
        sut = new EventServiceImpl();
    }

    @Test
    public void testCheckOverlappingBetweenEventsTrue() {
        //GIVEN
        Schedule schedule = new Schedule();
        schedule.setTitle("Simple schedule");
        EventFactory eventFactory = new EventFactory();
        Event funEvent = eventFactory.getEvent("FunEvent");
        funEvent.setStartActivity(LocalDateTime.of(2018, 1, 12, 12, 25));
        funEvent.setEndActivity(LocalDateTime.of(2018, 1, 20, 12, 25));
        funEvent.setTitle("fun event");
        schedule.add(funEvent);

        Event workEvent = eventFactory.getEvent("WorkEvent");
        workEvent.setStartActivity(LocalDateTime.of(2018, 1, 13, 12, 25));
        workEvent.setEndActivity(LocalDateTime.of(2018, 1, 25, 12, 25));
        workEvent.setTitle("work event");
        schedule.add(workEvent);
        //WHEN
        boolean result = sut.checkOverlappingBetweenEvents(workEvent, funEvent);
        //THEN
        assertFalse(result);
    }

    @Test
    public void testCheckOverlappingBetweenEventsFalse() {
        //GIVEN
        Schedule schedule = new Schedule();
        schedule.setTitle("Simple schedule");
        EventFactory eventFactory = new EventFactory();
        Event workEvent1 = eventFactory.getEvent("WorkEvent");
        workEvent1.setStartActivity(LocalDateTime.of(2018, 1, 12, 12, 25));
        workEvent1.setEndActivity(LocalDateTime.of(2018, 1, 20, 12, 25));
        workEvent1.setTitle("work event 1");
        schedule.add(workEvent1);

        Event workEvent2 = eventFactory.getEvent("WorkEvent");
        workEvent2.setStartActivity(LocalDateTime.of(2018, 1, 12, 12, 25));
        workEvent2.setEndActivity(LocalDateTime.of(2018, 1, 20, 12, 25));
        workEvent2.setTitle("work event 2");
        schedule.add(workEvent2);
        //WHEN
        boolean result = sut.checkOverlappingBetweenEvents(workEvent1, workEvent2);
        //THEN
        assertTrue(result);
    }
}
