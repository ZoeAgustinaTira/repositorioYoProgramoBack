package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Person;
import com.portfolio.portfolio.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/person")
public class PersonController {
        @Autowired
        IPersonService personService;

        @PostMapping("/register")
        public ResponseEntity<?> personRegister(@RequestBody Person Person){
            Person person = personService.savePerson(Person);
            return new ResponseEntity<>(person, HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
        public Person findById(@PathVariable("id") Integer id) {
            Person person= personService.find(id);
            return person;

        }

        @PutMapping("/update")
        public ResponseEntity<?> patientUpdate(@RequestBody Person person) {
            Person p = personService.updatePerson(person);
            //return ResponseEntity.ok(HttpStatus.OK);
            return new ResponseEntity<>(p, HttpStatus.OK);
        }

        @DeleteMapping("/delete/{id}")
        public ResponseEntity<?> personDelete(@PathVariable("id") Integer id) {
            personService.deletePerson(id);
            return ResponseEntity.ok(HttpStatus.OK);
        }



}
