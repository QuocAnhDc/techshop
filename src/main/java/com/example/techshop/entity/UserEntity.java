package com.example.techshop.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name ="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(length =128, nullable = false)
    private String email;

    @Column(length =64, nullable = false)
    private String password;

    @Column(name="first_name", length =45 , nullable =false)
    private String firstName;

    @Column(name="last_name", length =45 , nullable =false)
    private String lastName;

    @Column( length =300 )
    private String photos;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleEntity roleEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<OrderDetailEntity> orderDetailEntities;

    @Override
    public String toString() {
        return this.userId.toString()+"   "+ this.email.toString() +"   "+ this.roleEntity.toString() +"   "+ this.firstName + "  " + this.photos+ " " ;
    }
}
