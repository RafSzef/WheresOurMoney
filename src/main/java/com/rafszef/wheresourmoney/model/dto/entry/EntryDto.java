package com.rafszef.wheresourmoney.model.dto.entry;

import com.rafszef.wheresourmoney.model.entity.Category;
import com.rafszef.wheresourmoney.model.entity.User;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntryDto {

    private Long id;

    private Date timestamp;

    private BigDecimal amount;

    private User user;

    private Category category;

    private String description;
}
