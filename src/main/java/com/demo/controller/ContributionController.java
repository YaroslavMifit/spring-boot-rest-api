package com.demo.controller;

import com.demo.model.Contribution;
import com.demo.service.serviceImpl.ContributionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;


@RestController
@RequestMapping("/contributions")
public class ContributionController {

    @Autowired
    private ContributionServiceImpl contributionService;

    // вывод всех вкладов
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<Contribution>> getContributions() {

        return new ResponseEntity<>(contributionService.getAll(), HttpStatus.OK);
    }

    // вывод вклада по id
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Contribution> getContribution(@PathVariable long id) {
        Contribution contribution = contributionService.getByID(id);

        if (contribution != null) {
            return new ResponseEntity<>(contributionService.getByID(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>((Contribution) null, HttpStatus.NOT_FOUND);
        }
    }

    // добавление вклада
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ResponseEntity<?> addContribution(@RequestBody Contribution contribution) {
        return new ResponseEntity<>(contributionService.save(contribution), HttpStatus.CREATED);
    }

    // обновление вклада
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<?> updateContribution(@RequestBody Contribution contribution) {
        return new ResponseEntity<>(contributionService.update(contribution), HttpStatus.UPGRADE_REQUIRED);
    }

    // удаление вклада по id
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContribution(@PathVariable long id) {
        contributionService.remove(id);

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
