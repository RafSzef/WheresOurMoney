package com.rafszef.wheresourmoney.model.dto.entry;

import com.rafszef.wheresourmoney.model.dto.category.CategoryDto;
import com.rafszef.wheresourmoney.model.entity.User;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateEntryDto {

    private BigDecimal amount;

    private User user;

    private CategoryDto category;

    private String description;
}
