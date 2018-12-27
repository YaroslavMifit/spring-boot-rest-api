package com.demo.service;

import com.demo.model.Contribution;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface ContributionService {

    List<Contribution> getAll(Specification<Contribution> specification, Sort sort);
    Contribution getByID(long id);
    Contribution save(Contribution contribution);
    Contribution update(Contribution contribution);
    void remove(long id);

}
