package com.example.demo.controller;

import java.util.List;

import javax.websocket.server.PathParam;
import javax.xml.ws.Response;

import org.hibernate.engine.transaction.jta.platform.internal.ResinJtaPlatform;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.PageMeta;
import com.example.demo.dto.StaffDTO;
import com.example.demo.model.Movie;
import com.example.demo.model.Staff;
import com.example.demo.service.StaffService;
import com.google.gson.Gson;

@RestController
@RequestMapping("/api/")
public class StaffController {
    @Autowired
    StaffService staffService;
    @Autowired
    private ModelMapper modalmapper;

    @GetMapping("staffs")
    public ResponseEntity<List<StaffDTO>> getAllStaffs()
    {
        List<StaffDTO> staffs = staffService.getAllStaffs();
        if (staffs.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(staffs, HttpStatus.OK);
    }

    @GetMapping("staff")
    public ResponseEntity<Object> getAllStaffsByPage(@RequestParam(defaultValue = "1") int page,
    @RequestParam(defaultValue = "5") int size)
    {
       // page -= 1;
       //List<StaffDTO> staffs = staffService.getAllStaffsByPage(page, size);
       Page<Staff> staffPage = staffService.getAllStaffsByPage(page -1, size);
       
       
        if (staffPage.isEmpty())
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       // return new ResponseEntity<>(staffs, HttpStatus.OK);

       PageMeta meta = new PageMeta();
       meta.setPageNumber(staffPage.getNumber());
       meta.setPageSize(staffPage.getSize());
       meta.setTotalPages(staffPage.getTotalPages());
       meta.setTotalElements(staffPage.getTotalElements());
       ApiResponse res = new ApiResponse();
       res.setData(staffPage.getContent().stream().map(staff -> modalmapper.map(staff, StaffDTO.class)));
       res.setMeta(meta);
       res.setStatus(HttpStatus.OK.value());
        
        return new ResponseEntity<>(res, HttpStatus.OK);
    
    }

    @GetMapping("staff/{id}")
    public ResponseEntity<Object> findStaffById(@PathVariable int id)
    {
        Staff staff = staffService.findStaffById(id);
        if (staff == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Staff not existing to update", null));
        return new ResponseEntity<>(modalmapper.map(staff, StaffDTO.class), HttpStatus.OK);
    }
    
    @PostMapping("staff")
    public ResponseEntity<Object> createdStaff(@RequestBody StaffDTO staffDTO) {
        Staff staff = modalmapper.map(staffDTO, Staff.class);
        StaffDTO staff2 = staffService.save(staff);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.CREATED.value(), "Staff created successfully",
                staff2));

    }
    
    @PutMapping("staff/{id}")
    public ResponseEntity<Object> updateStaff(@PathVariable int id ,@RequestBody StaffDTO staffDTO)
    {
        Staff staffExisting = staffService.findStaffById(id);
      
        if (staffExisting == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Staff not existing to update", null));
        staffExisting.setName(staffDTO.getName());
        staffExisting.setPhone_number(staffDTO.getPhone_number());
        staffExisting.setBirthday(staffDTO.getBirthday());
        staffExisting.setAddress(staffDTO.getAddress());

        StaffDTO staff = staffService.save(staffExisting);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Staff updated successfully ", staff));

    }
    
    @DeleteMapping("staff/{id}")
    public ResponseEntity<Object> deleteStaff(@PathVariable int id) 
    {
        Staff staffExisting = staffService.findStaffById(id);
        if(staffExisting == null)
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ApiResponse(HttpStatus.NOT_FOUND.value(), "Staff not existing to update", null));
        staffService.deleteStaff(id);
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK.value(), "Deleted staff successfully", null));

    }
    
   


}
