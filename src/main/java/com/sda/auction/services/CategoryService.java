package com.sda.auction.services;

import com.sda.auction.entitites.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {
    void createCategory(Category category);
    List<Category> findAllCategories();
    Optional<Category> findById(int id);
    void updateCategory(Category category, int id) throws Exception;
    void deleteById(int id);

}
