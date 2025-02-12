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
public class JournalEntryControllerV2 {

    @GetMapping
    public List<JournalEntry> getAll() {
        return null;
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {

        return true;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEnteryById(@PathVariable long myId) {
        return null;

    }

    //
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEnteryById(@PathVariable long myId) {
        return null;

    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return null;
    }


}