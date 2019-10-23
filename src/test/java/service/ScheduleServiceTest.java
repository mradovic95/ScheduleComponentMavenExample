package service;

import exceptions.InvalidScheduleException;
import impl.EventServiceImpl;
import importexport.ScheduleImportExportJson;
import importexport.impl.SheduleImportExportJsonImplementation;
import model.Event;
import model.EventFactory;
import model.Schedule;
import org.junit.Test;
import service.impl.ScheduleServiceImpl;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;

public class ScheduleServiceTest {

    private ScheduleService sut;

    public ScheduleServiceTest() {
        ScheduleImportExportJson scheduleImportExportJsonImplementation = new SheduleImportExportJsonImplementation();
        EventService eventService = new EventServiceImpl();
        sut = new ScheduleServiceImpl(scheduleImportExportJsonImplementation, eventService);
    }

    @Test
    public void testLoadSchedule() throws IOException {
        //GIVEN
        String testFilePath = "TestSchedule.json";
        //WHEN
        Schedule schedule = sut.loadSchedule(new File(getClass().getClassLoader()
                .getResource(testFilePath)
                .getFile()));
        //THEN
        assertEquals("Simple schedule", schedule.getTitle());
        assertEquals("fun event", schedule.getEvents().get(0).getTitle());
        assertEquals("work event", schedule.getEvents().get(1).getTitle());
    }

    @Test
    public void testCheckSchedule() throws IOException, InvalidScheduleException {
        //GIVEN
        String testFilePath = "TestSchedule.json";
        Schedule schedule = sut.loadSchedule(new File(getClass().getClassLoader()
                .getResource(testFilePath)
                .getFile()));
        //WHEN
        sut.checkSchedule(schedule);
    }

    @Test
    public void testSaveSchedule() throws IOException {
        //GIVEN
        String testFilePath = "TestSchedule.json";
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
        sut.saveSchedule(new File(getClass().getClassLoader()
                .getResource(testFilePath)
                .getFile()), schedule);
    }
}
