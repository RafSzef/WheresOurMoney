package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;

import java.util.Set;

public interface CategoryService {

    Set<CategoryDto> getAllCategories();

    CategoryDto createCategory(CreateCategoryDto createCategoryDto);

    void removeCategory(CategoryDto categoryDto);

}
