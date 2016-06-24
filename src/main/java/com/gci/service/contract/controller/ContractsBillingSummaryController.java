package com.gci.service.contract.controller;

import com.gci.service.contract.model.ContractBillingSummary;
import com.gci.service.contract.service.ContractService;
import io.swagger.annotations.Api;
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


@RestController
@RequestMapping("/contractsummary")
@Api(value = "Contracts Billing Summary", description = "Retrieves Contracts Billing Summary Information")
public class ContractsBillingSummaryController {

    @Autowired
    ContractService contractService;

    @ApiOperation(value = "getContractsBillingSummaryByOwnerId")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId", value = "Contracts Billing Summary by Owner", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ContractBillingSummary.class),
            @ApiResponse(code = 404, message = "Not Found", response = ContractBillingSummary.class)
    })
    public ContractBillingSummary getContractsBillingSummaryByOwnerId(@PathVariable("userId") String ownerId) {
        return contractService.getContractsBilingSummaryByOwner(ownerId);
    }
}
