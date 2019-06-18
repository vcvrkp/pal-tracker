package io.pivotal.pal.tracker;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class InMemoryTimeEntryRepository implements  TimeEntryRepository {

    private HashMap<Long,TimeEntry> timeEntryRepo = new HashMap<>();
    private long counter = 0l;

    public TimeEntry create(TimeEntry timeEntry){
        if (timeEntry != null) {
            long id = ++counter;
            timeEntry.setId(id);
            timeEntryRepo.put(id,timeEntry);
        }
        return timeEntry;
    }

    public TimeEntry find(Long timeEntryId) {
        return timeEntryRepo.get(timeEntryId);
    }

    public List<TimeEntry> list(){

        List<TimeEntry> timeEntries = new ArrayList<>();
        timeEntries.addAll(timeEntryRepo.values());
            return timeEntries;

    }

    public TimeEntry update(Long id, TimeEntry expected){

       TimeEntry existing = timeEntryRepo.get(id);

       if(existing != null){
           expected.setId(id);
           timeEntryRepo.put(id, expected);

           return expected;
       }else return null;
    }


    public void  delete(Long id){
        timeEntryRepo.remove(id);
    }


}
