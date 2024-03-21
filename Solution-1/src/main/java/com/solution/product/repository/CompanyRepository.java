package com.solution.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.solution.product.model.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
