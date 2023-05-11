package com.example.demo.service;


import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.StaffDTO;
import com.example.demo.model.Customer;
import com.example.demo.model.Role;
import com.example.demo.model.Staff;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.StaffRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StaffServiceImpl implements StaffService{
    @Autowired
    private StaffRepository staffRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StaffDTO save(Staff staff) {
        return modelMapper.map(staffRepository.save(staff), StaffDTO.class);

    }

    @Override
    public Staff findStaffById(Integer id) {
        Optional<Staff> staff = staffRepository.findById(id);
        return staff.orElse(null);

    }

    @Override
    public void deleteStaff(Integer id) {
        staffRepository.deleteById(id);
    }

    @Override
    public List<StaffDTO> getAllStaffs() {
        return staffRepository.findAll().stream().map(
                staff -> modelMapper.map(staff, StaffDTO.class)).collect(Collectors.toList());
    }

    @Override
    public Page<Staff> getAllStaffsByPage(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<Staff> page = staffRepository.findAll(pageable);
        return page;
    }
    
    
    

    


    
}
