package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.BillDTO;
import com.example.demo.model.Bill;

public interface BillService {
    Bill save(Bill bill);

    BillDTO findById(Integer id);

    List<Bill> getAll();

    void deleteById(int id);

}
