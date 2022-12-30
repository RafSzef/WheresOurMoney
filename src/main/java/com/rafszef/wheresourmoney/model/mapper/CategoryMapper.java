package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.model.entity.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper {

    public CategoryDto toDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .categoryTitle(category.getCategoryTitle())
                .isActive(category.isActive())
                .build();
    }

    public Category toEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .categoryTitle(categoryDto.getCategoryTitle())
                .isActive(categoryDto.isActive())
                .build();
    }

    public CategoryDto toNewEntity(CreateCategoryDto createCategoryDto) {
        return CategoryDto.builder()
                .categoryTitle(createCategoryDto.getCategoryTitle())
                .isActive(createCategoryDto.isActive())
                .build();
    }
}
