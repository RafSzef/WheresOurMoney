package com.rafszef.wheresourmoney.model.dto.entry;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.entity.Category;
import com.rafszef.wheresourmoney.model.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEntryDto {

    private Date timestamp;

    private BigDecimal amount;

    private User user;

    private CategoryDto category;

    private String description;
}