package com.dinesh.firstspringbootapp.entity;

import org.springframework.http.HttpStatus;

public class ErrorMessage 
{
	
	
	private HttpStatus status;
	private String message;
	
	
	/**
	 * @return the status
	 */
	public HttpStatus getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	public ErrorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public ErrorMessage() {
		super();
	}
	
	
	@Override
	public String toString() {
		return "ErrorMessage [status=" + status + ", message=" + message + "]";
	}
}
