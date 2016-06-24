package com.gci.service.contract.repository;

import com.gci.service.contract.model.ServiceAgreement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServiceAgreementRepository extends JpaRepository<ServiceAgreement,Long> {
    List<ServiceAgreement> findByUserId(Long id) ;
    List<ServiceAgreement> findByUserUsername(String username) ;
}
