package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;

public interface BranchService {
    List<BranchDTO> getAllBrand();
    void save(BranchDTO brandDTO);
    void update(BranchDTO brandDTO);
    void delete(Integer id);
    BranchDTO findById(Integer id);
    List<BranchDTO> getAddressBrand();
    List<BranchDTO> getAgency(String address);
}
