package com.gci.service.contract.controller;

import com.gci.service.contract.model.Contract;
import com.gci.service.contract.model.ContractBillingSummary;
import com.gci.service.contract.model.ServiceOrder;
import com.gci.service.contract.service.ContractService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contracts")
@Api(value = "Contracts", description = "Retrieves Contracts Information")
public class ContractsController {

    @Autowired
    ContractService contractService;

    @ApiOperation(value = "getAllContractsByOwnerId")
    @RequestMapping(value = "/{userId}", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "userId", value = "Contracts by Owner", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 404, message = "Not Found", response = List.class)
    })
    public List<Contract> getAllContracts(@PathVariable("userId") String ownerId) {
        return contractService.getContractsByOwner(ownerId);
    }

    @ApiOperation(value = "createServiceOrderContract")
    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = ServiceOrder.class),
            @ApiResponse(code = 404, message = "Not Found", response = ServiceOrder.class)
    })
    public ServiceOrder createServiceOrder(@RequestBody ServiceOrder contract) {
        return contractService.createServiceOrder(contract);
    }

}
