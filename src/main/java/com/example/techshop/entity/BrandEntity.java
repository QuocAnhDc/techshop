package com.example.techshop.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "brands")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BrandEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Integer brandId;

    @Column(name = "description")
    private String description;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brandEntity", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<ProductEntity> productEntityList;
}
