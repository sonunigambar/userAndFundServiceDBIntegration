package com.codingcure.fundservice.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codingcure.fundservice.entity.Fund;

@Repository
public interface FundRepo extends JpaRepository<Fund, Integer>{

}
