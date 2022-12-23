package com.rafszef.wheresourmoney.model.dto.account;

import com.rafszef.wheresourmoney.model.dto.entry.EntryDto;
import com.rafszef.wheresourmoney.model.entity.Entry;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {

    private Long id;

    private String name;

    private List<EntryDto> entries;
}
