package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.entity.User;
import net.engineeringdigest.journalApp.service.JournalEntryService;
import net.engineeringdigest.journalApp.service.UserService;
import org.apache.commons.collections.FastHashMap;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("{userName}")
    public ResponseEntity<?> getAllJournalEntryOfUser(@PathVariable String userName) {
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName) {
       try{
           myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
    }catch (Exception e) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }
       }

//    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEnteryById(@PathVariable ObjectId myId) {
//      return journalEntryService.findById(myId).orElse(null);
//    }
// -----------------------------------Entity response for HTTP states code show in postman----------------------------
@GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEnteryById(@PathVariable ObjectId myId) {
      Optional<JournalEntry> journalEntry = journalEntryService.findById(myId);
             if (journalEntry.isPresent()){
                 return new ResponseEntity<>(journalEntry.get(), HttpStatus.OK);
             }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}
    //-------------------------------------------------------------------------------------
    //
    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEnteryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
       return new ResponseEntity<>(old, HttpStatus.OK);
        }
        journalEntryService.saveEntry(old);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}