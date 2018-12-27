package com.demo.service;

import com.demo.model.Bank;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface BankService {

    List<Bank> getAll(Specification<Bank> specification, Sort sort);
    Bank getByID(long id);
    Bank save(Bank bank);
    Bank update(Bank bank);
    void remove(long id);

}
