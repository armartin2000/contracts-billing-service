package com.gci.service.contract.repository;

import com.gci.service.contract.model.LineItemContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface LineItemContractRepository extends JpaRepository<LineItemContract,Long> {
    List<LineItemContract> findByUserId(Long id) ;
    List<LineItemContract> findByUserUsername(String username) ;
}
