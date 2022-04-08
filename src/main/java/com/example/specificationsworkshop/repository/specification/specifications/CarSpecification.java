package com.example.specificationsworkshop.repository.specification.specifications;

import com.example.specificationsworkshop.models.Car;
import com.example.specificationsworkshop.repository.specification.criteria.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public record CarSpecification<T extends Comparable<T>>(
        SearchCriteria<T> criteria) implements Specification<Car> {

    @Override
    public Predicate toPredicate(Root<Car> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThan(
                    root.get(criteria.getKey()), criteria.getValue());
        } else if (criteria.getOperation().equalsIgnoreCase(":")) {
            return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
        }
        return null;
    }
}
