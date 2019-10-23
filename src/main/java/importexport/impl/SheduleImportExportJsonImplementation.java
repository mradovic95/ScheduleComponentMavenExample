package importexport.impl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import importexport.ScheduleImportExportJson;
import model.Event;
import model.Schedule;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class SheduleImportExportJsonImplementation implements ScheduleImportExportJson {

    @Override
    public Schedule importSchedule(File file) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Event.class, new InterfaceAdapter<Event>()).create();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        Schedule schedule = gson.fromJson(reader, Schedule.class);
        reader.close();
        return schedule;
    }

    @Override
    public void exportSchedule(File file, Schedule schedule) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().registerTypeAdapter(Event.class, new InterfaceAdapter<Event>()).create();
        Writer writer = new FileWriter(file);
        gson.toJson(schedule, writer);
        writer.flush();
    }

}
