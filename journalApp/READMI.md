//-------------------MongoDB POSTMAN code GET,POST,PUT,DELETE--------------------------------------
package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.service.JournalEntryService;
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

    @GetMapping
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public JournalEntry getJournalEnteryById(@PathVariable ObjectId myId) {
      return journalEntryService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
     public boolean deleteJournalEnteryById(@PathVariable ObjectId myId) {
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
        JournalEntry old = journalEntryService.findById(id).orElse(null);
        if(old != null){
            old.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.equals("") ? newEntry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(old);
        return old;
    }
}

//  ---------------- response Entity ---------------------11v--13:28---------
// samjhau 
// ---public ResponseEntity<?> deleteJournalEnteryById(@PathVariable ObjectId myId) {
public ke pass jha return type hota h vha ye likh dena h ~~~ ResponseEntity<?> ~~~
and
// ---return new ResponseEntity<>(HttpStatus.NOT_FOUND);
return me ~~~ new ResponseEntity<>(HttpStatus.NOT_FOUND); ~~~
--ye kar dete h 

file code of requestEntity http code show --------------------------------------------
@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<JournalEntry> all = journalEntryService.getAll();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry) {
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




//------------------------mongoDB Relationship in SpringBoot User.java file se -----------13v--
27017> show dbs
admin      40.00 KiB
config     72.00 KiB
journaldb  72.00 KiB
local      72.00 KiB
school     72.00 KiB

27017> use journaldb
switched to db journaldb
journaldb> show collections
journal_entries
journaldb> db.createCollection("users")
{ ok: 1 }

// -------------------------@Autowired annotation --------------------------
@Autowired ek annotation hai jo Spring framework mein use hota hai. Yeh dependency injection ke liye
use hota hai. Is case mein, journalEntryRepository ko automatically inject kar diya jaata hai,
jab class ka instance create hota hai.

Matlab, aap ko manually object banane ki zarurat nahi padti. Spring context yeh kaam aapke liye
automatically kar deta hai, aur JournalEntryRepository ko inject kar deta hai jo us service ya 
repository ka implementation hai.
Kuch aisa hota hai:
java
public class MyService {
@Autowired
private JournalEntryRepository journalEntryRepository;

    // Methods that use journalEntryRepository
}