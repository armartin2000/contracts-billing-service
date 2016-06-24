package com.gci.service.contract.service;

import com.gci.service.contract.model.Site;
import com.gci.service.contract.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {

    private SiteRepository siteRepository;

    @Autowired
    public SiteService (SiteRepository siteRepository) {
        this.siteRepository = siteRepository;
    }

    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    public Site getSiteById(String siteId) {
        return siteRepository.findOne(Long.valueOf(siteId));
    }
}
