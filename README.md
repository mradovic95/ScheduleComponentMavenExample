
# Schedule Component

This component can handle schedules in different formats.

## Features

List if features:

* Can import schedule in selected format and convert it to object model
    * JSON
    * XML (not implemented)
    * CSV (not implemented)
* Can export schedule to selected format
    * JSON
    * XML (not implemented)
    * CSV (not implemented)
* Can edit schedule after import and before export

## Example

Import schedule in JSON format example:

```
ScheduleImportExportJson scheduleImportExportJsonImplementation = new SheduleImportExportJsonImplementation();
        EventService eventService = new EventServiceImpl();
        ScheduleService scheduleService = new ScheduleServiceImpl(scheduleImportExportJsonImplementation, eventService);

        try {
            Schedule schedule = scheduleService.loadSchedule(new File("Proba.json"));
            scheduleService.checkSchedule(schedule);
            System.out.println(schedule.getTitle());
            schedule.getEvents().forEach(event -> System.out.println(event.getTitle()));
        } catch (IOException | InvalidScheduleException e) {
            e.printStackTrace();
        }
```

Export schedule to JSON format:

```
Schedule schedule = new Schedule();
        schedule.setTitle("Simple schedule");
        EventFactory eventFactory = new EventFactory();
        Event workEvent1 = eventFactory.getEvent("FunEvent");
        workEvent1.setStartActivity(LocalDateTime.of(2018, 1, 12, 12, 25));
        workEvent1.setEndActivity(LocalDateTime.of(2018, 1, 20, 12, 25));
        workEvent1.setTitle("fun event");
        schedule.add(workEvent1);

        Event workEvent2 = eventFactory.getEvent("WorkEvent");
        workEvent2.setStartActivity(LocalDateTime.of(2018, 1, 13, 12, 25));
        workEvent2.setEndActivity(LocalDateTime.of(2018, 1, 25, 12, 25));
        workEvent2.setTitle("work event");
        schedule.add(workEvent2);

        ScheduleImportExportJson scheduleImportExportJsonImplementation = new SheduleImportExportJsonImplementation();
        EventService eventService = new EventServiceImpl();
        ScheduleService scheduleService = new ScheduleServiceImpl(scheduleImportExportJsonImplementation, eventService);

        try {
            scheduleService.checkSchedule(schedule);
            scheduleService.saveSchedule(new File("Proba.json"), schedule);
        } catch (IOException | InvalidScheduleException e) {
            e.printStackTrace();
        }
```

## Authors

 Name          | E-mail              
---------------| ----------------- 
Mihailo Radovic| mradovic15@raf.rs 