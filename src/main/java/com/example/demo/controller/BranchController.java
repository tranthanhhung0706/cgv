package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BranchDTO;
import com.example.demo.dto.BrandDTO;
import com.example.demo.model.Branch;
import com.example.demo.service.BranchService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class BranchController {
    @Autowired
    private BranchService branchService;

    @GetMapping("brand")
    public List<BranchDTO> getAll(){
        return branchService.getAllBrand();
    }
    @GetMapping("brand/{id}")
    public BranchDTO getBrandById(@PathVariable int id){
        return branchService.findById(id);
    }
    @PostMapping("brand")
    public List<BranchDTO> save(@RequestBody BranchDTO branchDTO){
        branchService.save(branchDTO);
        return branchService.getAllBrand();
    }
    @PutMapping(value="brand/{id}")
    public List<BranchDTO> update(@RequestBody BranchDTO branchDTO,@PathVariable("id") Integer id){
            try {
                branchDTO.setId(id);
                branchService.update(branchDTO);
                return branchService.getAllBrand();
            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
    }
    @DeleteMapping("brand/{id}")
    public List<BranchDTO> delete(@PathVariable("id") Integer id){
        branchService.delete(id);
        return branchService.getAllBrand();
    }
     @GetMapping("branch/address")
     public List<BranchDTO> getAddress(){
         return branchService.getAddressBrand();
     }
     
     @GetMapping("branch/{address}")
     public List<BranchDTO> getAgency(@PathVariable("address") String address){
    	 return branchService.getAgency(address);
     }
    
}
