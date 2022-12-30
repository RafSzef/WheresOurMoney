package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    List<CategoryDto> getAllCategories();
    Set<CategoryDto> getAllActiveCategories();
    Set<CategoryDto> getAllInactiveCategories();
    CategoryDto changeIsActive(Long categoryId);
    CategoryDto createCategory(CreateCategoryDto createCategoryDto);
    void removeCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryId);
}
