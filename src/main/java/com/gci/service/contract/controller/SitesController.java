package com.gci.service.contract.controller;

import com.gci.service.contract.model.Site;
import com.gci.service.contract.service.SiteService;
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
@RequestMapping(path = "/sites")
public class SitesController {

    @Autowired
    SiteService siteService;

    @ApiOperation(value = "getSiteById")
    @RequestMapping(value = "/{siteId}", method = RequestMethod.GET, produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(
                    name = "siteId", value = "Site", required = true, dataType = "string", paramType = "path")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Site.class),
            @ApiResponse(code = 404, message = "Not Found", response = Site.class)
    })
    public Site getUserById(@PathVariable("siteId") String siteId) {
        return siteService.getSiteById(siteId);
    }

    @ApiOperation(value = "getAllSites")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 404, message = "Not Found", response = List.class)
    })
    public List<Site> getAllUsers() {
        return siteService.getAllSites();
    }


}
