package com.solution.product.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.solution.product.exception.CompanyValidationException;
import com.solution.product.exception.ItemAlreadyExistsException;
import com.solution.product.model.Company;
import com.solution.product.model.ErrorObject;
import com.solution.product.service.CompanyService;

import jakarta.validation.Valid;

@RestController
public class CompanyController {

    @Autowired
    private CompanyService companyService;

//    @PostMapping("/registercompany")
//    public ResponseEntity<?> registerCompany(@Valid @RequestBody Company company) {
//        try {
//            // Call the registerCompany method in the service layer
//            Company registeredCompany = companyService.registerCompany(company);
//            
//            // If registration is successful, return the registered company and HTTP status 201 (CREATED)
//            return new ResponseEntity<>(registeredCompany, HttpStatus.CREATED);
//        } catch (Exception e) {
//            // If an exception occurs during registration, return an error message and HTTP status 500 (INTERNAL_SERVER_ERROR)
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    
//    @PostMapping("/registercompany")
//    public ResponseEntity<?> registerCompany(@Valid @RequestBody Company company, BindingResult bindingResult) {
//        
//		if (bindingResult.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return ResponseEntity.badRequest().body(errors);
//        }
//
//        try {
//            // Call the registerCompany method in the service layer
//            Company registeredCompany = companyService.registerCompany(company);
//
//            // If registration is successful, return the registered company and HTTP status 201 (CREATED)
//            return new ResponseEntity<>(registeredCompany, HttpStatus.CREATED);
//        } catch (ItemAlreadyExistsException e) {
//            // If the company already exists, return an error message and HTTP status 409 (CONFLICT)
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
//        } catch (CompanyValidationException e) {
//            // If there's a validation issue with the company data, return an error message and HTTP status 400 (BAD REQUEST)
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        } catch (Exception e) {
//            // If an unexpected exception occurs during registration, return an error message and HTTP status 500 (INTERNAL_SERVER_ERROR)
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
//    @PostMapping("/registercompany")
//    public ErrorObject registerCompany(@Valid @RequestBody Company company, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            Map<String, String> errors = new HashMap<>();
//            for (FieldError fieldError : bindingResult.getFieldErrors()) {
//                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
//            }
//            return new ErrorObject(HttpStatus.BAD_REQUEST, "Invalid request content.", new Date(0));
//        }
//
//        try {
//            // Call the registerCompany method in the service layer
//            companyService.registerCompany(company);
//
//            // If registration is successful, return the registered company and HTTP status 201 (CREATED)
//            return new ErrorObject(HttpStatus.CREATED, "Company registered successfully.", new Date(0));
//        } catch (ItemAlreadyExistsException e) {
//            // If the company already exists, return an error message and HTTP status 409 (CONFLICT)
//            return new ErrorObject(409, e.getMessage(), new Date(0));
//        } catch (CompanyValidationException e) {
//            // If there's a validation issue with the company data, return an error message and HTTP status 400 (BAD REQUEST)
//            return new ErrorObject(400, e.getMessage(), new Date(0));
//        } catch (Exception e) {
//            // If an unexpected exception occurs during registration, return an error message and HTTP status 500 (INTERNAL_SERVER_ERROR)
//            return new ErrorObject(500, e.getMessage(), new Date(0));
//        }
//    }
    
  

    @PostMapping("/registercompany")
    public ResponseEntity<?> registerCompany(@Valid @RequestBody Company company, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                errors.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errors);
        }

        try {
            Company registeredCompany = companyService.registerCompany(company);
            return ResponseEntity.status(HttpStatus.CREATED).body(registeredCompany);
        } catch (ItemAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ErrorObject(HttpStatus.CONFLICT.value(), e.getMessage(), java.sql.Date.valueOf(LocalDate.now())));
        } catch (CompanyValidationException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorObject(HttpStatus.BAD_REQUEST.value(), e.getMessage(), java.sql.Date.valueOf(LocalDate.now())));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorObject(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), java.sql.Date.valueOf(LocalDate.now())));
        }
    }

}
