package com.gci.service.contract.repository;

import com.gci.service.contract.model.ServiceOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ServiceOrderRepository extends JpaRepository<ServiceOrder,Long> {
    List<ServiceOrder> findByUserId(Long id) ;
    List<ServiceOrder> findByUserUsername(String username) ;
}