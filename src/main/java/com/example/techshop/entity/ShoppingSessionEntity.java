package com.example.techshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "shopping_session")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingSessionEntity {

  @Id
  @Column(name = "session_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer sessionId;

  @Column(name = "total")
  private int total;

  @OneToOne
  @JoinColumn(name = "cus_id", nullable = false)
  private UserEntity userEntity;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingSessionEntity",cascade = CascadeType.REMOVE, orphanRemoval = true)
  private List<CartItemEntity> cartItemEntityList;
}
