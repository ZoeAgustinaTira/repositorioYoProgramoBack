package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Education;

import java.util.List;

public interface IEducationService {
    public Education saveEdu (Education edu);


    public Education findEdu (Integer id);

    public Education updateEdu (Education edu);

    public List<Education> seeEdu();

    public void deleteEdu (Integer id);

}
