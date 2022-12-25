package com.rafszef.wheresourmoney.service.category;

import com.rafszef.wheresourmoney.model.dto.account.AccountDto;
import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.dto.category.CreateCategoryDto;
import com.rafszef.wheresourmoney.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<AccountDto> getAllCategories() {
        return null;
    }

    @Override
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        return null;
    }

    @Override
    public CategoryDto removeCategory(CategoryDto categoryDto) {
        return null;
    }
}
