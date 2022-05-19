package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Contact;

import com.portfolio.portfolio.service.IContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/contact")
public class ContactController {
    @Autowired
    IContactService contactService;

    @PostMapping("/register")
    public ResponseEntity<?> contactRegister(@RequestBody Contact contact){
        Contact c = contactService.saveContact(contact);
        return new ResponseEntity<>(c, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Contact findById(@PathVariable("id") Integer id) {
        Contact contact= contactService.findContact(id);
        return contact;

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Contact>> findContacts(){
        return ResponseEntity.ok(contactService.contacts());

    }

    @PutMapping("/update")
    public ResponseEntity<?> contactUpdate(@RequestBody Contact contact) {
        Contact c = contactService.updateContact(contact);
        return new ResponseEntity<>(c, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> contactDelete(@PathVariable("id") Integer id) {
        contactService.deleteContact(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
