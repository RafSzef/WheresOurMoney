package com.rafszef.wheresourmoney.model.mapper;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
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
                .build();
    }

    public Category toNewEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .categoryTitle(categoryDto.getCategoryTitle())
                .build();
    }
}
