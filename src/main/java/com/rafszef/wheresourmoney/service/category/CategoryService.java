package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.account.CreateAccountDto;
import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;

import java.util.List;

public interface CategoryService {

    List<AccountDto> getAllCategories();

    CategoryDto createCategory(CreateCategoryDto createCategoryDto);

    CategoryDto removeCategory(CategoryDto categoryDto);

}
