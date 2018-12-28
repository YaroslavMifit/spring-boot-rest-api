package com.demo.repository.specification;

import com.demo.model.Client;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ClientSpecification implements Specification<Client> {

    private final Client client;

    public ClientSpecification(Client client) {
        this.client = client;
    }

    @Override
    public Predicate toPredicate(Root<Client> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicate = new ArrayList<>();

        if(client.getId() != null) {
            predicate.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("id"))), "%" + client.getId() + "%".toUpperCase()));
        }
        if (client.getName() != null) {
            predicate.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("name")), "%" + client.getName() + "%".toUpperCase()));
        }
        if (client.getShortName() != null) {
            predicate.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("shortName")), "%" + client.getShortName() + "%".toUpperCase()));
        }
        if (client.getAddress() != null) {
            predicate.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("address")), "%" + client.getAddress() + "%".toUpperCase()));
        }
        if (client.getLegalOrganizationForm() != null) {
            predicate.add(criteriaBuilder.equal(root.get("legalOrganizationForm"), client.getLegalOrganizationForm()));
        }

        return criteriaBuilder.and(predicate.toArray(new Predicate[predicate.size()]));
    }
}
