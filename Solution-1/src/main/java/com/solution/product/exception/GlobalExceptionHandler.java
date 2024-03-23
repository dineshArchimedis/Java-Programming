//////package com.solution.product.exception;
//////
//////import java.util.Date;
//////
//////import org.springframework.http.HttpStatus;
//////import org.springframework.http.ResponseEntity;
//////import org.springframework.web.bind.annotation.ExceptionHandler;
//////import org.springframework.web.context.request.WebRequest;
//////import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//////import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//////
//////import com.solution.product.model.ErrorObject;
//////
//////public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
//////	
//////	@ExceptionHandler(ItemAlreadyExistsException.class)
//////	public ResponseEntity<ErrorObject> handleItemExistsException(ItemAlreadyExistsException ex, WebRequest request)
//////	{
//////		ErrorObject errorObject = new ErrorObject();
//////		errorObject.setStatusCode(HttpStatus.CONFLICT.value());
//////		errorObject.setMessage(ex.getMessage());
//////		errorObject.setTimestamp(new Date());
//////		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.CONFLICT); 
//////		
//////	}
//////	
//////	@ExceptionHandler(Exception.class)
//////	public ResponseEntity<ErrorObject> handleGeneralException(Exception ex,
//////																	  WebRequest request)
//////	{
//////		ErrorObject errorObject = new ErrorObject();
//////		errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//////		errorObject.setMessage(ex.getMessage());
//////		errorObject.setTimestamp(new Date());
//////		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR); 
//////	}
//////	
//////	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
//////	public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,
//////																	  WebRequest request)
//////	{
//////		ErrorObject errorObject = new ErrorObject();
//////		errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
//////		errorObject.setMessage(ex.getMessage());
//////		errorObject.setTimestamp(new Date());
//////		return new ResponseEntity<ErrorObject>(errorObject, HttpStatus.BAD_REQUEST); 
//////	}
//////
//////}
////
////
////package com.solution.product.exception;
////
////
////import java.util.Date;
////
////import org.springframework.http.HttpStatus;
////import org.springframework.http.ResponseEntity;
////import org.springframework.validation.BindingResult;
////import org.springframework.validation.FieldError;
////import org.springframework.web.bind.MethodArgumentNotValidException;
////import org.springframework.web.bind.annotation.ControllerAdvice;
////import org.springframework.web.bind.annotation.ExceptionHandler;
////import org.springframework.web.context.request.WebRequest;
////import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
////import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
////
////import com.solution.product.model.ErrorObject;
////
////@ControllerAdvice
////public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
////
////    
////    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
////                                                                  org.springframework.http.HttpHeaders headers, HttpStatus status,
////                                                                  WebRequest request) {
////        ErrorObject errorObject = new ErrorObject();
////        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
////
////        BindingResult bindingResult = ex.getBindingResult();
////        StringBuilder errorMessage = new StringBuilder();
////        for (FieldError fieldError : bindingResult.getFieldErrors()) {
////            errorMessage.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
////        }
////        errorObject.setMessage(errorMessage.toString());
////
////        errorObject.setTimestamp(new Date());
////        return handleExceptionInternal(ex, errorObject, headers, HttpStatus.BAD_REQUEST, request);
////    }
////    
////    @ExceptionHandler(CompanyValidationException.class)
////    public ResponseEntity<ErrorObject> handleCompanyValidationException(CompanyValidationException ex,
////                                                                         WebRequest request) {
////        ErrorObject errorObject = new ErrorObject();
////        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
////        errorObject.setMessage(ex.getMessage());
////        errorObject.setTimestamp(new Date());
////        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
////    }
////
////    @ExceptionHandler(ItemAlreadyExistsException.class)
////    public ResponseEntity<ErrorObject> handleItemExistsException(ItemAlreadyExistsException ex,
////                                                                 WebRequest request) {
////        ErrorObject errorObject = new ErrorObject();
////        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
////        errorObject.setMessage(ex.getMessage());
////        errorObject.setTimestamp(new Date());
////        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
////    }
////
////    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
////    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,
////                                                                             WebRequest request) {
////        ErrorObject errorObject = new ErrorObject();
////        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
////        errorObject.setMessage(ex.getMessage());
////        errorObject.setTimestamp(new Date());
////        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
////    }
////
////    @ExceptionHandler(Exception.class)
////    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
////        ErrorObject errorObject = new ErrorObject();
////        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
////        errorObject.setMessage(ex.getMessage());
////        errorObject.setTimestamp(new Date());
////        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
////    }
////}
////
//
//package com.solution.product.exception;
//
//import java.util.Date;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
//
//import com.solution.product.model.ErrorObject;
//
//@ControllerAdvice
//public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
//
//    
//    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//                                                                  org.springframework.http.HttpHeaders headers, HttpStatus status,
//                                                                  WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
//
//        BindingResult bindingResult = ex.getBindingResult();
//        StringBuilder errorMessage = new StringBuilder();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            errorMessage.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
//        }
//        errorObject.setMessage(errorMessage.toString());
//
//        errorObject.setTimestamp(new Date());
//        return handleExceptionInternal(ex, errorObject, headers, HttpStatus.BAD_REQUEST, request);
//    }
//
//    @ExceptionHandler(CompanyValidationException.class)
//    public ResponseEntity<ErrorObject> handleCompanyValidationException(CompanyValidationException ex,
//                                                                         WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        errorObject.setMessage(ex.getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(ItemAlreadyExistsException.class)
//    public ResponseEntity<ErrorObject> handleItemExistsException(ItemAlreadyExistsException ex,
//                                                                 WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
//        errorObject.setMessage(ex.getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
//    }
//
//    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
//    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,
//                                                                             WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
//        errorObject.setMessage(ex.getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        errorObject.setMessage(ex.getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}


package com.solution.product.exception;

import java.util.Date;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.solution.product.model.ErrorObject;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  org.springframework.http.HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());

        BindingResult bindingResult = ex.getBindingResult();
        StringBuilder errorMessage = new StringBuilder();
        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessage.append(fieldError.getField()).append(": ").append(fieldError.getDefaultMessage()).append(", ");
        }
        errorObject.setMessage(errorMessage.toString());

        errorObject.setTimestamp(new Date());
        return handleExceptionInternal(ex, errorObject, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(CompanyValidationException.class)
    public ResponseEntity<ErrorObject> handleCompanyValidationException(CompanyValidationException ex,
                                                                         WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ErrorObject> handleItemExistsException(ItemAlreadyExistsException ex,
                                                                 WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorObject> handleMethodArgumentMismatchException(MethodArgumentTypeMismatchException ex,
                                                                             WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorObject> handleGeneralException(Exception ex, WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorObject.setMessage(ex.getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
    }
////    
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    public ResponseEntity<ErrorObject> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
//                                                                               WebRequest request) {
//        ErrorObject errorObject = new ErrorObject();
//        errorObject.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
//        errorObject.setMessage("Internal Server Error: " + ex.getRootCause().getMessage());
//        errorObject.setTimestamp(new Date());
//        return new ResponseEntity<>(errorObject, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
    
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorObject> handleDataIntegrityViolationException(DataIntegrityViolationException ex,
                                                                               WebRequest request) {
        ErrorObject errorObject = new ErrorObject();
        errorObject.setStatusCode(HttpStatus.CONFLICT.value());
        errorObject.setMessage("Item already exists: " + ex.getRootCause().getMessage());
        errorObject.setTimestamp(new Date());
        return new ResponseEntity<>(errorObject, HttpStatus.CONFLICT);
    }
}

