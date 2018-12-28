package com.demo.repository.specification;

import com.demo.model.Contribution;
import com.demo.util.DateSearchUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ContributionSpecification implements Specification<Contribution> {

    private final Contribution contribution;

    public ContributionSpecification(Contribution contribution) {
        this.contribution = contribution;
    }

    @Override
    public Predicate toPredicate(Root<Contribution> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if(contribution.getId() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("id"))), "%" + contribution.getId() + "%".toUpperCase()));
        }
        if (contribution.getClient() != null) {

            if(contribution.getClient().getId() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("client").get("id"))), "%" + contribution.getClient().getId() + "%".toUpperCase()));
            }
            if (contribution.getClient().getName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("client").get("name")), "%" + contribution.getClient().getName() + "%".toUpperCase()));
            }
            if (contribution.getClient().getShortName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("client").get("shortName")), "%" + contribution.getClient().getShortName() + "%".toUpperCase()));
            }
            if (contribution.getClient().getAddress() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("client").get("address")), "%" + contribution.getClient().getAddress() + "%".toUpperCase()));
            }
            if (contribution.getClient().getLegalOrganizationForm() != null) {
                predicates.add(criteriaBuilder.equal(root.get("client").get("legalOrganizationForm"), contribution.getClient().getLegalOrganizationForm()));
            }
        }
        if (contribution.getBank() != null) {

            if(contribution.getBank().getId() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("bank").get("id"))), "%" + contribution.getBank().getId() + "%".toUpperCase()));
            }
            if (contribution.getBank().getName() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(root.get("bank").get("name")), "%" + contribution.getBank().getName().toUpperCase() + "%"));
            }
            if (contribution.getBank().getBik() != null) {
                predicates.add(criteriaBuilder.like(criteriaBuilder.upper(criteriaBuilder.function("CONCAT", String.class, root.get("bank").get("bik"))), "%" + contribution.getBank().getBik() + "%".toUpperCase()));
            }
        }
        if (contribution.getOpenDate() != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get("openDate"), contribution.getOpenDate()));
            predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get("openDate"), DateSearchUtils.atEndOfDay(contribution.getOpenDate())));
        }
        if (contribution.getPercent() != null) {
            predicates.add(criteriaBuilder.equal(root.get("percent"), contribution.getPercent()));
        }
        if (contribution.getTermInMonths() != null) {
            predicates.add(criteriaBuilder.like(criteriaBuilder.function("CONCAT", String.class, root.get("termInMonths")), "%" + contribution.getTermInMonths() + "%"));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
