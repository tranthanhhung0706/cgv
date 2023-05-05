package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    public List<BrandDTO> getAll(){
        return branchService.getAllBrand();
    }
    @GetMapping("brand/{id}")
    public BrandDTO getBrandById(@PathVariable int id){
        return branchService.findById(id);
    }
    @PostMapping("brand")
    public List<BrandDTO> save(@RequestBody BrandDTO brandDTO){
        branchService.save(brandDTO);
        return branchService.getAllBrand();
    }
    @PutMapping(value="brand/{id}")
    public List<BrandDTO> update(@RequestBody BrandDTO brandDTO,@PathVariable int id){
            try {
                brandDTO.setId(id);
                branchService.update(brandDTO);
                return branchService.getAllBrand();
            } catch (Exception e) {
                // TODO: handle exception
            }
            return null;
    }
    @DeleteMapping("brand/{id}")
    public List<BrandDTO> delete(@PathVariable int id){
        branchService.delete(id);
        return branchService.getAllBrand();
    }
    
}
