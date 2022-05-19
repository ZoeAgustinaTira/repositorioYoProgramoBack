package com.portfolio.portfolio.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio.model.Skill;
import com.portfolio.portfolio.repository.ISkillRepository;
import com.portfolio.portfolio.service.ISkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkillService implements ISkillService {
    @Autowired
    private ISkillRepository skillRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Skill saveSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill updateSkill(Skill skill) {
        return skillRepository.save(skill);
    }

    @Override
    public Skill findSkill(Integer id) {
        Optional<Skill> skill = skillRepository.findById(id);
        if(skill.isPresent()){
            return mapper.convertValue(skill, Skill.class);
        }
        return null;
    }

    @Override
    public List<Skill> skills() {
        List<Skill> skills = skillRepository.findAll();

        return skills;
    }


    @Override
    public void deleteSkill(Integer id) {
        skillRepository.deleteById(id);
    }
}
