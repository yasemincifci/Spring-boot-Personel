package com.postgrebaglanti.deneme.dao;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder

@Table(name = "personel")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",nullable = false)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "city")
    private String city;


}
