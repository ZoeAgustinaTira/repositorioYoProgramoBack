package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Education;
import com.portfolio.portfolio.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/education")
public class EducationController {
    @Autowired
    IEducationService educationService;

    @PostMapping("/register")
    public ResponseEntity<?> educationRegister(@RequestBody Education education){
        Education e = educationService.saveEdu(education);
        return new ResponseEntity<>(e, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Education findById(@PathVariable("id") Integer id) {
        Education education= educationService.findEdu(id);
        return education;

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Education>> findEducations(){
        return ResponseEntity.ok(educationService.seeEdu());

    }

    @PutMapping("/update")
    public ResponseEntity<?> educationUpdate(@RequestBody Education education) {
        Education e = educationService.updateEdu(education);
        return new ResponseEntity<>(e, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> educationDelete(@PathVariable("id") Integer id) {
        educationService.deleteEdu(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

}
