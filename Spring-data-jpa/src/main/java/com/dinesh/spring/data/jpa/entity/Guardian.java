package com.dinesh.spring.data.jpa.entity;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
		@AttributeOverride(
				name="name",
				column=@Column(name="guardian_name")
		),
		@AttributeOverride(
				name="email",
				column=@Column(name="guardian_email")
		),
		@AttributeOverride(
				name="mobile",
				column=@Column(name="guardian_mobile")
		)
})
public class Guardian 
{
	private String name;
	private String email;
	private String mobile;
	
	@Override
	public String toString() {
		return "Guardian [name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public Guardian(String name, String email, String mobile) {
		super();
		this.name = name;
		this.email = email;
		this.mobile = mobile;
	}
	public Guardian() {
		super();
	}
	
	
	
}
