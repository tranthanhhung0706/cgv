package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;

@Component
public class BrandConvert {
    public BrandDTO toDto(Branch branch){
        BrandDTO brandDTO=new BrandDTO();
        brandDTO.setId(branch.getId());
        brandDTO.setDiaChi(branch.getDiaChi());
        brandDTO.setImgURL(branch.getImgURL());
        brandDTO.setName(branch.getName());
        brandDTO.setPhoneNo(branch.getPhoneNo());
        return brandDTO;
    }
    public Branch toEntity(BrandDTO brandDTO){
        Branch branch=new Branch();
        branch.setName(brandDTO.getName());
        branch.setDiaChi(brandDTO.getDiaChi());
        branch.setImgURL(brandDTO.getImgURL());
        branch.setPhoneNo(brandDTO.getPhoneNo());
        return branch;
    }
    public Branch toEntity2(BrandDTO brandDTO,Branch branch){
        branch.setDiaChi(brandDTO.getDiaChi());
        branch.setImgURL(brandDTO.getImgURL());
        branch.setName(brandDTO.getName());
        branch.setPhoneNo(brandDTO.getPhoneNo());
        return branch;
    }
    
}
