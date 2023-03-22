package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.BrandConvert;
import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService{
    @Autowired 
    private BranchRepository branchRepository;
    @Autowired
    private BrandConvert brandConvert;
    @Override
    public List<BrandDTO> getAllBrand() {
        List<Branch> list=branchRepository.findAll();
	List<BrandDTO> listBrandDTOs=new ArrayList<>();
	for(int i=0;i<list.size();i++) {
		listBrandDTOs.add(brandConvert.toDto(list.get(i)));
	}
        // TODO Auto-generated method stub
        return listBrandDTOs;
    }
    @Override
    public void save(BrandDTO brandDTO) {
        // TODO Auto-generated method stub
        Branch branch=brandConvert.toEntity(brandDTO);
        branchRepository.save(branch);
    }
    @Override
    public void update(BrandDTO brandDTO) {
        // TODO Auto-generated method stub
        Branch oldbrand=branchRepository.getById(brandDTO.getId());
	    Branch newbrand=brandConvert.toEntity2(brandDTO, oldbrand);
	    branchRepository.save(newbrand);
    }
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        branchRepository.deleteById(id);
    }
    @Override
    public BrandDTO findById(Integer id) {
        // TODO Auto-generated method stub
        Branch branch=new Branch();
        branch=branchRepository.getById(id);
        return brandConvert.toDto(branch);
    }
    
}
