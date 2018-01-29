package com.demo.controller;

import com.demo.model.Bank;
import com.demo.service.serviceImpl.BankServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/banks")
public class BankController {

    @Autowired
    private BankServiceImpl bankService;

    // вывод всех банков
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Bank>> getBanks() {
        return new ResponseEntity<>(bankService.getAll(), HttpStatus.OK);
    }

    // вывод банкa по id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Bank> getBank(@PathVariable long id) {
        Bank bank = bankService.getByID(id);

        if (bank != null) {
            return new ResponseEntity<>(bankService.getByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Bank) null, HttpStatus.NOT_FOUND);
        }
    }

    // добавление банка
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addBank(@RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.save(bank), HttpStatus.CREATED);
    }

    // обновление банка
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateBank(@RequestBody Bank bank) {
        return new ResponseEntity<>(bankService.update(bank), HttpStatus.UPGRADE_REQUIRED);
    }

    // удаление банка по id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteBank(@PathVariable long id) {
        bankService.remove(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
