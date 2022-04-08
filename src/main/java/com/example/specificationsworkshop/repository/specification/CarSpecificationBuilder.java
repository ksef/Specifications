package com.example.specificationsworkshop.repository.specification;

import com.example.specificationsworkshop.models.Car;
import com.example.specificationsworkshop.repository.specification.criteria.SearchCriteria;
import com.example.specificationsworkshop.repository.specification.specifications.CarSpecification;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

@EqualsAndHashCode
public class CarSpecificationBuilder {

    private static final List<String> datesTimesFields = List.of("creationDateTime");
    private static final List<String> numberFields = List.of("vinCode");

    private static final int KEY_GROUP = 1;
    private static final int OPERATION_GROUP = 2;
    private static final int VALUE_GROUP = 3;

    private final String searchQuery;
    private final Pattern pattern = Pattern.compile("(\\w+?)([:<>])\"([^\"]+)\"");

    public CarSpecificationBuilder(String searchQuery) {
        this.searchQuery = searchQuery;
    }

    public Optional<Specification<Car>> build() {
        return pattern.matcher(searchQuery).results().map(this::getSpecification).reduce(Specification::and);
    }

    private Specification<Car> getSpecification(MatchResult matchResult) {
        String key = matchResult.group(KEY_GROUP);
        String operation = matchResult.group(OPERATION_GROUP);
        String value = matchResult.group(VALUE_GROUP);
        if (datesTimesFields.contains(key)) {
            LocalDateTime dateTime = LocalDateTime.parse(matchResult.group(VALUE_GROUP));
            return new CarSpecification<>(new SearchCriteria<>(key, operation, dateTime));
        } else if (numberFields.contains(key)){
            return new CarSpecification<>(new SearchCriteria<>(key, operation, value));
        } else {
            throw new IllegalArgumentException("Used invalid search query");
        }
    }
}
