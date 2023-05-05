package com.example.demo.service;


import java.util.List;

import org.springframework.data.domain.Page;

import com.example.demo.model.Customer;
import com.example.demo.model.Staff;
import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.StaffDTO;

public interface StaffService  {
    StaffDTO save(Staff staff);

    Staff findStaffById(Integer id);

    void deleteStaff(Integer id);
    
    Page<Staff>  getAllStaffsByPage(int pageNumber, int pageSize);
    List<StaffDTO> getAllStaffs();
  
   
}
