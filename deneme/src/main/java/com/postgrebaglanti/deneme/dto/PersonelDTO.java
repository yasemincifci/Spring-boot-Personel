package com.postgrebaglanti.deneme.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonelDTO {
    private Long id;
    private String name;
    private String lastname;
    private String city;
}
