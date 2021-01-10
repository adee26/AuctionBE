package com.sda.auction.controllers;

import com.sda.auction.entitites.Auction;
import com.sda.auction.entitites.Category;
import com.sda.auction.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){
        return categoryService.findAllCategories();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int id){
        return categoryService.findById(id);
    }

    @PostMapping
    public void addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public void editUser(@PathVariable("id") int id, @RequestBody Category category) throws Exception{
        categoryService.updateCategory(category, id);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable("id") int id){
        categoryService.deleteById(id);
    }

    @GetMapping("/category/{id}")
    public List<Auction> getAuctionListByCategoryId(@PathVariable("id") int id){
        return categoryService.findById(id).get().getAuctionList();
    }
}
