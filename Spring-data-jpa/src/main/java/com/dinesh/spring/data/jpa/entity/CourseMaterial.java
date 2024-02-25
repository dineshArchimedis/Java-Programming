package com.dinesh.spring.data.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class CourseMaterial 
{
	@Id
	@SequenceGenerator(name="course_material_sequence",sequenceName="course_material_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="course_material_sequence")
	private Long courseMaterialId;
	private String url;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="course_id",referencedColumnName="courseId")
	private Course course;
	
	@Override
	public String toString() {
		return "CourseMaterial [courseMaterialId=" + courseMaterialId + ", url=" + url + "]";
	}
	/**
	 * @return the courseMaterialId
	 */
	public Long getCourseMaterialId() {
		return courseMaterialId;
	}
	/**
	 * @param courseMaterialId the courseMaterialId to set
	 */
	public void setCourseMaterialId(Long courseMaterialId) {
		this.courseMaterialId = courseMaterialId;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	public CourseMaterial(Long courseMaterialId, String url) {
		super();
		this.courseMaterialId = courseMaterialId;
		this.url = url;
	}
	public CourseMaterial() {
		super();
	}
	
	
}
