package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.enums.CategoryName;
import com.example.coffeeshop.repository.CategoryRepository;
import com.example.coffeeshop.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() != 0){
            return;
        }
        Arrays.stream(CategoryName.values())
                .forEach(categoryName -> {
                    Category category = new Category();
                    category.setName(categoryName);
                    switch (categoryName){
                        case CAKE:
                            category.setNeededTime(10);
                            break;
                        case DRINK:
                            category.setNeededTime(1);
                            break;
                        case COFFEE:
                            category.setNeededTime(2);
                            break;
                        case OTHER:
                            category.setNeededTime(5);
                            break;
                    }
                    categoryRepository.save(category);
                });
    }

    @Override
    public Category findByCategoryName(CategoryName category) {
        return categoryRepository.findByName(category).orElse(null);
    }
}
