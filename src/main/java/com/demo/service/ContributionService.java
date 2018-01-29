package com.demo.service;

import com.demo.model.Contribution;

import java.util.List;

public interface ContributionService {

    List<Contribution> getAll();
    Contribution getByID(long id);
    Contribution save(Contribution contribution);
    Contribution update(Contribution contribution);
    void remove(long id);

}
