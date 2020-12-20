package com.sda.auction.services;

import com.sda.auction.entitites.Category;
import com.sda.auction.repositories.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public void createCategory(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void updateCategory(Category category, int id) throws Exception {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        if(categoryOptional.isPresent()){
            categoryOptional.get().setDescription(category.getDescription());
            categoryOptional.get().setName(category.getName());
            categoryOptional.get().setAuctionList(category.getAuctionList());
            categoryRepository.save(categoryOptional.get());
        } else {
            throw new Exception("Cannot find category");
        }

    }

    @Override
    public void deleteById(int id) {
        categoryRepository.deleteById(id);
    }
}
