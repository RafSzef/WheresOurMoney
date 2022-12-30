package com.rafszef.wheresourmoney.controller;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/all")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("/allInactive")
    public Set<CategoryDto> getAllInactiveCategories() {
        return categoryService.getAllInactiveCategories();
    }

    @GetMapping("/allActive")
    public Set<CategoryDto> getAllActiveCategories() {
        return categoryService.getAllActiveCategories();
    }
    @PutMapping("/changeActive")
    public CategoryDto changeActive(@RequestParam Long categoryId) {
        return categoryService.changeIsActive(categoryId);
    }

    @PutMapping("/updateName")
    public CategoryDto changeName(@RequestBody CategoryDto categoryDto) {
        return categoryService.updateCategory(categoryDto);
    }

    @PostMapping("/add")
    public CategoryDto createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryService.createCategory(createCategoryDto);
    }

    @DeleteMapping("/delete")
    public void deleteCategory(@RequestBody CategoryDto categoryDto) {
        categoryService.removeCategory(categoryDto);
    }
}
