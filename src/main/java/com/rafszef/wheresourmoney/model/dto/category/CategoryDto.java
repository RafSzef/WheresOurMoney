package com.rafszef.wheresourmoney.model.dto.category;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private Long id;
    private String categoryTitle;
    private boolean isActive;
    public void changeActive() {
        isActive = !isActive;
    }
}
