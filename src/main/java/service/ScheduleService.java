package service;

import exceptions.InvalidScheduleException;
import model.Schedule;

import java.io.File;
import java.io.IOException;

public interface ScheduleService {

    void checkSchedule(Schedule schedule) throws InvalidScheduleException;

    Schedule loadSchedule(File file) throws IOException;

    void saveSchedule(File file, Schedule schedule) throws IOException;

}
