package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import org.apache.commons.collections.FastHashMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/journal")
@RequestMapping("_/journal")
public class JournalEntryController {

    private Map<Long, JournalEntry> journalEntries = new HashMap<>();

    //isse sabhi id title content aa jayega
    @GetMapping
    public List<JournalEntry> getAll() {
        return new ArrayList<>(journalEntries.values());
        // //localhost:8081/journal    for Get body row json
    }

    //data send krne ke liye id title content
//    @PostMapping
//    public boolean createEntry(@RequestBody JournalEntry myEntry) {
//        //localhost:8081/journal    for Post body row json
//        journalEntries.put(myEntry.getId(), myEntry);
//        return true;
//    }

    //one id title content dekhna ho to use this //spacfic general entry
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEnteryById(@PathVariable long myId) {
        return journalEntries.get(myId);
    }

    //
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEnteryById(@PathVariable long myId) {
        return journalEntries.remove(myId);
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return journalEntries.put(id, myEntry);
    }


}