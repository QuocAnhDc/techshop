package com.example.techshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryEntity implements Comparable<CategoryEntity> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "categoryEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductEntity> productEntityList;

    @Override
    public int compareTo(CategoryEntity category) {
        return (this.categoryId - category.getCategoryId());
    }
}
