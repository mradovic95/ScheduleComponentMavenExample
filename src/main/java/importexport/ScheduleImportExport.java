package importexport;

import model.Schedule;

import java.io.IOException;

/**
 * Represents abstract model of schedule importer.
 *
 * @author comex
 */

public interface ScheduleImportExport<T> {

    /**
     * @param source data source which contains data for schedule
     * @return Schedule object from JSON
     * @throws IOException IO Exception
     */
    Schedule importSchedule(T source) throws IOException;

    /**
     * @param destination where export schedule
     * @param schedule    schedule we wont to export
     * @throws IOException IO Exception
     */
    void exportSchedule(T destination, Schedule schedule) throws IOException;

}
