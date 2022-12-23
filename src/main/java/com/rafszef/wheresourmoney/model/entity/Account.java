package com.rafszef.wheresourmoney.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "accounts")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany
    private List<Entry> entries;
}
