package com.demo.service.serviceImpl;

import com.demo.repository.ContributionRepository;
import com.demo.service.ContributionService;
import com.demo.model.Contribution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public class ContributionServiceImpl implements ContributionService {

    @Autowired
    private ContributionRepository contributionRepository;

    @Override
    public List<Contribution> getAll() {
        return contributionRepository.findAll();
    }

    @Override
    public Contribution getByID(long id) {
        return contributionRepository.findOne(id);
    }

    @Override
    public Contribution save(Contribution contribution) {
        return contributionRepository.save(contribution);
    }

    @Override
    public Contribution update(Contribution contribution) {
        return contributionRepository.saveAndFlush(contribution);
    }

    @Override
    public void remove(long id) {
        contributionRepository.delete(id);
    }
}
