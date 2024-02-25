package com.dinesh.spring.data.jpa.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Teacher 
{
	

	@Id
	@SequenceGenerator(name="teacher_sequence",sequenceName="teacher_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="teacher_sequence")
	private Long teacherId;
	private String firstName;
	private String lastName;
	
//	@OneToMany(cascade=CascadeType.ALL)
//	@JoinColumn(name="teacher_id",referencedColumnName="teacherId")
//	private List<Course> course;
	
	@Override
	public String toString() {
		return "Teacher [teacherId=" + teacherId + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	

	/**
	 * @return the teacherId
	 */
	public Long getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(Long teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the course
	 */
//	public List<Course> getCourse() {
//		return course;
//	}
//
//	/**
//	 * @param course the course to set
//	 */
//	public void setCourse(List<Course> course) {
//		this.course = course;
//	}

	public Teacher(Long teacherId, String firstName, String lastName, List<Course> course) {
		super();
		this.teacherId = teacherId;
		this.firstName = firstName;
		this.lastName = lastName;
		//this.course = course;
	}

	public Teacher() {
		super();
	}
	
	
	
	
}
