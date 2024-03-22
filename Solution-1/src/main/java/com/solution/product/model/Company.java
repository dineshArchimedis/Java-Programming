package com.solution.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "company", uniqueConstraints = {@UniqueConstraint(columnNames = {"companyName", "companyEmail", "username"})})
public class Company {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long companyId;
	
	@NotBlank(message = "Company name is required")
	@Size(max = 255, message = "Company name must be less than or equal to 255 characters")
	@Column(nullable = false, unique = true)
    private String companyName;
	
	@NotNull(message = "Company type is required")
//  @Pattern(regexp = "^(product base|service base|other)$", message = "Company type must be 'product base', 'service base', or 'other'")
	@Pattern(regexp = "^(product base|service base|other|Product Base|Service Base|Other)$", message = "Company type must be 'product base', 'service base', or 'other'")
    private String companyType;
	
	@NotBlank(message = "Company email is required")
    @Email(message = "Invalid email format")
	@Size(max = 255, message = "Company email must be less than or equal to 255 characters")
	@Column(nullable = false, unique = true)
    private String companyEmail;
	
	@Column
    private String companyAddress;
    
	@Column(nullable = false, unique = true)
    private String username;
    
	@Column
    private String password;
	
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", companyType=" + companyType
				+ ", companyEmail=" + companyEmail + ", companyAddress=" + companyAddress + ", username=" + username
				+ ", password=" + password + "]";
	}

	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyType
	 */
	public String getCompanyType() {
		return companyType;
	}

	/**
	 * @param companyType the companyType to set
	 */
	public void setCompanyType(String companyType) {
		this.companyType = companyType;
	}

	/**
	 * @return the companyEmail
	 */
	public String getCompanyEmail() {
		return companyEmail;
	}

	/**
	 * @param companyEmail the companyEmail to set
	 */
	public void setCompanyEmail(String companyEmail) {
		this.companyEmail = companyEmail;
	}

	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	

	public Company(Long companyId,
			@NotBlank(message = "Company name is required") @Size(max = 255, message = "Company name must be less than or equal to 255 characters") String companyName,
			@NotNull(message = "Company type is required") @Pattern(regexp = "^(product base|service base|other|Product Base|Service Base|Other)$", message = "Company type must be 'product base', 'service base', or 'other'") String companyType,
			@NotBlank(message = "Company email is required") @Email(message = "Invalid email format") @Size(max = 255, message = "Company email must be less than or equal to 255 characters") String companyEmail,
			String companyAddress, String username, String password) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.companyType = companyType;
		this.companyEmail = companyEmail;
		this.companyAddress = companyAddress;
		this.username = username;
		this.password = password;
	}

	public Company() {
		super();
	}
    
	    
    
}
