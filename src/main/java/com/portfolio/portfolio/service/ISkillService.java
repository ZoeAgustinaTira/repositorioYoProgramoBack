package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Skill;

import java.util.List;

public interface ISkillService {
    public Skill saveSkill (Skill skill);

    public Skill updateSkill (Skill skill);

    public Skill findSkill (Integer id);

    public List<Skill> skills();

    public void deleteSkill (Integer id);


}
