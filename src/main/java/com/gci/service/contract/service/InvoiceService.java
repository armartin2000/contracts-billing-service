package com.gci.service.contract.service;

import com.gci.service.contract.model.Invoice;
import com.gci.service.contract.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceService {
    private InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService (InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(String invoiceId) {
        return invoiceRepository.findOne(Long.valueOf(invoiceId));
    }
}
