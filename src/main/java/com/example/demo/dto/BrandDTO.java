package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Data
@NoArgsConstructor
public class BrandDTO {
    private Integer id;
    private String imgURL;
    private String name;
    private String diaChi;
    private String phoneNo;
    
}
