package com.example.specificationsworkshop.repository.specification.criteria;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class SearchCriteria<T> {
    private String key;
    private String operation;
    private T value;
}
