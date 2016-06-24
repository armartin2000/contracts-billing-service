package com.gci.service.contract.repository;

import com.gci.service.contract.model.Site;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SiteRepository extends JpaRepository<Site,Long> {
}
