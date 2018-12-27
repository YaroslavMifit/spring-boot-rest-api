package com.demo.repository;

import com.demo.model.Contribution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ContributionRepository extends JpaRepository<Contribution, Long>, JpaSpecificationExecutor<Contribution> {

}