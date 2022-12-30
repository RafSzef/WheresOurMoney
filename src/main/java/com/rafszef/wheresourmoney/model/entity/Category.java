package com.rafszef.wheresourmoney.model.entity;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @Column (name = "category_title", unique = true)
    private String categoryTitle;

    @Column (name = "active")
    @Type(type = "numeric_boolean")
    private boolean isActive;
}
