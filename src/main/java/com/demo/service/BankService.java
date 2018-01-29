package com.demo.service;

import com.demo.model.Bank;

import java.util.List;

public interface BankService {

    List<Bank> getAll();
    Bank getByID(long id);
    Bank save(Bank bank);
    Bank update(Bank bank);
    void remove(long id);

}
