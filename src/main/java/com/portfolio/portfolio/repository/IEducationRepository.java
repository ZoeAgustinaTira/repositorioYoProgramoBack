package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEducationRepository extends JpaRepository<Education, Integer> {
}
