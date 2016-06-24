package com.gci.service.contract.controller;

import com.gci.service.contract.model.Invoice;
import com.gci.service.contract.model.Site;
import com.gci.service.contract.service.InvoiceService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/invoices")

public class InvoicesController {

    @Autowired
    private InvoiceService invoiceService;

    @ApiOperation(value = "getInvoicesById")
    @RequestMapping(value = "/{invoiceId}", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "invoiceId", value = "Invoice", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Invoice.class),
            @ApiResponse(code = 404, message = "Not Found", response = Invoice.class)
    })
    public Invoice getInvoiceById(@PathVariable("invoiceId") String invoiceId) {
        return invoiceService.getInvoiceById(invoiceId);
    }

    @ApiOperation(value = "getAllInvoices")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 404, message = "Not Found", response = List.class)
    })
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

}
