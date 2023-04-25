package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BillDTO;
import com.example.demo.service.BillService;

@RequestMapping("/api")
@RestController
public class BillController {
    @Autowired
    BillService billService;

    @GetMapping("/bill")
    public ResponseEntity<?> getBill(@RequestParam int id) {
        try {
            // add create date to billdto
            BillDTO response = billService.findById(id);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // TODO: handle exception
            return ResponseEntity.badRequest().body("Error get bill by id " + e.getLocalizedMessage());
        }
    }
}
