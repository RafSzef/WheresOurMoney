package com.rafszef.wheresourmoney.controller;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.service.category.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/all")
    public Set<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/add")
    public CategoryDto createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        return categoryService.createCategory(createCategoryDto);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/delete")
    public void deleteCategory (@RequestBody CategoryDto categoryDto) {
        categoryService.removeCategory(categoryDto);
    }
}
