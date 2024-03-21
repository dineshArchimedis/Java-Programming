package com.solution.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solution.product.model.Company;
import com.solution.product.service.CompanyService;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping("/registercompany")
    public ResponseEntity<?> registerCompany(@RequestBody Company company) {
        try {
            // Call the registerCompany method in the service layer
            Company registeredCompany = companyService.registerCompany(company);
            
            // If registration is successful, return the registered company and HTTP status 201 (CREATED)
            return new ResponseEntity<>(registeredCompany, HttpStatus.CREATED);
        } catch (Exception e) {
            // If an exception occurs during registration, return an error message and HTTP status 500 (INTERNAL_SERVER_ERROR)
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
