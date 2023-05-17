package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BillDTO;
import com.example.demo.model.Bill;
import com.example.demo.repository.BillRepository;
import com.example.demo.repository.TicketRepository;

@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    TicketService ticketService;

    @Override
    public Bill save(Bill bill) {
        // TODO Auto-generated method stub
        Bill thisBill = billRepository.save(bill);
        return thisBill;
    }

    @Override
    public List<Bill> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public BillDTO findById(Integer id) {
        // TODO Auto-generated method stub
        BillDTO dto = new BillDTO();
        Bill bill = billRepository.findById(id).orElse(null);

        // convert
        if (bill != null) {
            dto.setId(bill.getId());
            dto.setTickets(ticketService.findByBill(bill));
        }
        return dto;
    }

    @Override
    public void deleteById(int id) {
        // TODO Auto-generated method stub
        billRepository.deleteById(id);
    }

}
