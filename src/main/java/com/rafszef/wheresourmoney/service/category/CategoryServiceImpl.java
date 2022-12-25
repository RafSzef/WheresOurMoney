package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.model.mapper.CategoryMapper;
import com.rafszef.wheresourmoney.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public Set<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        CategoryDto categoryDto = categoryMapper.toNewEntity(createCategoryDto);
        return categoryMapper.toDto(categoryRepository.save(categoryMapper.toEntity(categoryDto)));
    }

    @Override
    public void removeCategory(CategoryDto categoryDto) {
        var category = categoryRepository.findById(categoryDto.getId());

        if (category.isPresent()) {
            categoryRepository.deleteById(category.get().getId());
        } else throw new EntityNotFoundException("No category found");
    }
}
