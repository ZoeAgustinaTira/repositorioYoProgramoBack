package com.portfolio.portfolio.controller;

import com.portfolio.portfolio.model.Skill;
import com.portfolio.portfolio.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    ISkillService skillService;

    @PostMapping("/register")
    public ResponseEntity<?> skillRegister(@RequestBody Skill skill){
        Skill s = skillService.saveSkill(skill);
        return new ResponseEntity<>(s, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public Skill findById(@PathVariable("id") Integer id) {
        Skill skill= skillService.findSkill(id);
        return skill;

    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Skill>> findSkills(){
        return ResponseEntity.ok(skillService.skills());

    }

    @PutMapping("/update")
    public ResponseEntity<?> skillUpdate(@RequestBody Skill skill) {
        Skill s = skillService.updateSkill(skill);
        return new ResponseEntity<>(s, HttpStatus.OK);
        //return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> skillDelete(@PathVariable("id") Integer id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
