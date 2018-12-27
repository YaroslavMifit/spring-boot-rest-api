package com.demo.repository.specification;

import com.demo.model.Bank;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BankSpecification implements Specification<Bank> {

    private final Bank bank;
    public BankSpecification(Bank bank) {
        this.bank = bank;
    }

    @Override
    public Predicate toPredicate(Root<Bank> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(bank.getId() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("id"))), "%" + bank.getId() + "%".toUpperCase()));
        }
        if (bank.getName() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + bank.getName().toUpperCase() + "%"));
        }
        if (bank.getBik() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("bik"))), "%" + bank.getBik() + "%".toUpperCase()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
