package com.rafszef.wheresourmoney.model.dto.category;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateCategoryDto {

    private String categoryTitle;
    private boolean isActive;
}
