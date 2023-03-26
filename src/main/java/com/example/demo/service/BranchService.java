package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;

public interface BranchService {
    List<BrandDTO> getAllBrand();
    void save(BrandDTO brandDTO);
    void update(BrandDTO brandDTO);
    void delete(Integer id);
    BrandDTO findById(Integer id);
}
