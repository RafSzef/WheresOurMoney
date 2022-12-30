package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.model.entity.Category;
import com.rafszef.wheresourmoney.model.mapper.CategoryMapper;
import com.rafszef.wheresourmoney.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll().stream()
                .map(categoryMapper::toDto)
                .sorted((o1, o2) -> o1.getId().compareTo(o2.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Set<CategoryDto> getAllActiveCategories() {
        return categoryRepository.findAll().stream()
                .filter(Category::isActive)
                .map(categoryMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public Set<CategoryDto> getAllInactiveCategories() {
        return categoryRepository.findAll().stream()
                .filter(category -> !category.isActive())
                .map(categoryMapper::toDto)
                .collect(Collectors.toSet());
    }

    @Override
    public CategoryDto changeIsActive(Long categoryId) {
        var category = categoryRepository.findById(categoryId);
        if (category.isPresent()) {
            var categoryDto = categoryMapper.toDto(category.get());
            categoryDto.changeActive();
            categoryRepository.save(categoryMapper.toEntity(categoryDto));
            return categoryDto;
        }else throw new EntityNotFoundException("Category with id " + categoryId + " not found");
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

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto) {
        var category = categoryRepository.findById(categoryDto.getId());
        if (category.isPresent()) {
            category.get().setCategoryTitle(categoryDto.getCategoryTitle());
            return categoryMapper.toDto(categoryRepository.save(category.get()));
        } else throw new EntityNotFoundException("No category found");
    }
}
