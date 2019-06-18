package io.pivotal.pal.tracker;

import java.util.List;

public interface TimeEntryRepository {
    public TimeEntry create(TimeEntry timeEntry) ;
    public TimeEntry find(Long timeEntryId) ;
    public List<TimeEntry> list();
    public TimeEntry update(Long id, TimeEntry expected) ;
    public void  delete(Long id) ;
}
