package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.Category;
import com.example.coffeeshop.model.enums.CategoryName;

public interface CategoryService {
    void initCategories();

    Category findByCategoryName(CategoryName category);
}
