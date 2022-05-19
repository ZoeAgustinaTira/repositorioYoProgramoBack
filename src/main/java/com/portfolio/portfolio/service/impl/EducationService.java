package com.portfolio.portfolio.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.portfolio.model.Education;

import com.portfolio.portfolio.repository.IEducationRepository;
import com.portfolio.portfolio.service.IEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EducationService implements IEducationService {
    @Autowired
    private IEducationRepository educationRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public Education saveEdu(Education edu) {
        return educationRepository.save(edu);
    }

    @Override
    public Education findEdu(Integer id) {
        Optional<Education> education = educationRepository.findById(id);
        if(education.isPresent()){
            return mapper.convertValue(education, Education.class);
        }
        return null;
    }

    @Override
    public Education updateEdu(Education edu) {
        return educationRepository.save(edu);
    }

    @Override
    public List<Education> seeEdu() {
        List<Education> educations = educationRepository.findAll();

        return educations;
    }

    @Override
    public void deleteEdu(Integer id) {
        educationRepository.deleteById(id);
    }
}
