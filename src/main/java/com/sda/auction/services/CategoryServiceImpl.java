package com.sda.auction.services;

import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryService categoryService;

    public CategoryServiceImpl(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
}
