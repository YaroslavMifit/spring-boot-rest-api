package com.demo.service.serviceImpl;

import com.demo.repository.BankRepository;
import com.demo.repository.specification.BankSpecification;
import com.demo.service.BankService;
import com.demo.model.Bank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Repository
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

    @Override
    public List<Bank> getAll(Bank bank, Sort sort) {

        return bankRepository.findAll(new BankSpecification(bank), sort);
    }

    @Override
    public Bank getByID(long id) {
        return bankRepository.findOne(id);
    }

    @Override
    public Bank save(Bank bank) {
        return bankRepository.save(bank);
    }

    @Override
    public Bank update(Bank bank) {
        return bankRepository.saveAndFlush(bank);
    }

    @Override
    public void remove(long id) {
        bankRepository.delete(id);
    }
}
