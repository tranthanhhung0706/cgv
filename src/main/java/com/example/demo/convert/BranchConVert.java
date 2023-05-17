package com.example.demo.convert;

import org.springframework.stereotype.Component;

import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;

@Component
public class BranchConVert {
	public Branch toEntity(BranchDTO branchDTO) {
		Branch branch = new Branch();
		branch.setId(branchDTO.getId());
		branch.setDiaChi(branchDTO.getDiaChi());
		branch.setImgURL(branchDTO.getImgURL());
		branch.setName(branchDTO.getName());
		branch.setPhoneNo(branchDTO.getName());
		return branch;
	}
	
	public BranchDTO toDTO(Branch branch) {
		BranchDTO branchDTO = new BranchDTO();
		branchDTO.setId(branch.getId());
		branchDTO.setDiaChi(branch.getDiaChi());
		branchDTO.setImgURL(branch.getImgURL());
		branchDTO.setName(branch.getName());
		branchDTO.setPhoneNo(branch.getPhoneNo());
		return branchDTO;
	}
	
	public Branch toEntity(BranchDTO branchDTO,Branch branch){
        branch.setDiaChi(branchDTO.getDiaChi());
        branch.setImgURL(branchDTO.getImgURL());
        branch.setName(branchDTO.getName());
        branch.setPhoneNo(branchDTO.getPhoneNo());
        return branch;
    }
}
