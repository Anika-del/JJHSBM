package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.apache.commons.collections.FastHashMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    @GetMapping
    public List<JournalEntry> getAll(){
        return new ArrayList<>(journalEntries.values());
        // //localhost:8081/journal    for Get body row json
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        //localhost:8081/journal    for Post body row json
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }

    @PutMapping("/{id}")
    public boolean updateEntry(@PathVariable Long id, @RequestBody JournalEntry updatedEntry) {
        if (journalEntries.containsKey(id)) {
            journalEntries.put(id, updatedEntry);
            return true;
        }
        return false;


    }}
