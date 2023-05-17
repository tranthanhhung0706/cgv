package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.convert.BranchConVert;
import com.example.demo.convert.BrandConvert;
import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;
import com.example.demo.repository.BranchRepository;

@Service
public class BranchServiceImpl implements BranchService{
    @Autowired 
    private BranchRepository branchRepository;
    @Autowired
    private BranchConVert branchConvert;
    @Override
    public List<BranchDTO> getAllBrand() {
        List<Branch> list=branchRepository.findAll();
	List<BranchDTO> listBrandDTOs=new ArrayList<>();
	for(int i=0;i<list.size();i++) {
		listBrandDTOs.add(branchConvert.toDTO(list.get(i)));
	}
        // TODO Auto-generated method stub
        return listBrandDTOs;
    }
    @Override
    public void save(BranchDTO brandDTO) {
        // TODO Auto-generated method stub
        Branch branch=branchConvert.toEntity(brandDTO);
        branchRepository.save(branch);
    }
    @Override
    public void update(BranchDTO brandDTO) {
        // TODO Auto-generated method stub
        Branch oldbrand=branchRepository.getById(brandDTO.getId());
	    Branch newbrand=branchConvert.toEntity(brandDTO, oldbrand);
	    branchRepository.save(newbrand);
    }
    @Override
    public void delete(Integer id) {
        // TODO Auto-generated method stub
        branchRepository.deleteById(id);
    }
    @Override
    public BranchDTO findById(Integer id) {
        // TODO Auto-generated method stub
        Branch branch=new Branch();
        branch=branchRepository.getById(id);
        return branchConvert.toDTO(branch);
    }
    @Override
    public List<BranchDTO> getAddressBrand(){
    	List<Branch> list = branchRepository.findAll();
    	List<BranchDTO> listResult = new ArrayList<BranchDTO>();
    	for (Branch branch : list) {
    		boolean check = false;
			for (BranchDTO branchDTO : listResult) {
				if(branchDTO.getDiaChi().equals(branch.getDiaChi()))
				{
					check = true;
					break;
				}
			}
			if(!check)
				listResult.add(branchConvert.toDTO(branch));
		}
    	return listResult;
    }
	@Override
	public List<BranchDTO> getAgency(String address) {
		List<Branch> list = branchRepository.findAll();
    	List<BranchDTO> listResult = new ArrayList<BranchDTO>();
    	for (Branch branch : list) {
    		if(branch.getDiaChi().equals(address))
				listResult.add(branchConvert.toDTO(branch));
		}
    	return listResult;
	}
    
}
