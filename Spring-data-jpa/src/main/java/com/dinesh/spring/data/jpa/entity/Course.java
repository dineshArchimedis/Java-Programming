package com.dinesh.spring.data.jpa.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Course 
{
	
	@Id
	@SequenceGenerator(name="course_sequence",sequenceName="course_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="course_sequence")
	private Long courseId;
	private String courseTitle;
	private Integer credit;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course_map",
			   joinColumns=@JoinColumn(name="course_id",
			   referencedColumnName="courseId"),
			   inverseJoinColumns = @JoinColumn(name="student_id",referencedColumnName="studentId")
	)
	private List<Student> students;
	
	public void addStudents(Student student) {
		if(students=null) students=new ArrayList<>();
		students.add(student);
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="teacher_id",referencedColumnName="teacherId")
	private Teacher teacher;
	
	@OneToOne(mappedBy="course")
	private CourseMaterial courseMaterial;
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseTitle=" + courseTitle + ", credit=" + credit + "]";
	}
	/**
	 * @return the courseId
	 */
	public Long getCourseId() {
		return courseId;
	}
	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}
	/**
	 * @return the courseTitle
	 */
	public String getCourseTitle() {
		return courseTitle;
	}
	/**
	 * @param courseTitle the courseTitle to set
	 */
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	/**
	 * @return the credit
	 */
	public Integer getCredit() {
		return credit;
	}
	/**
	 * @param credit the credit to set
	 */
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	
	public Course(Long courseId, String courseTitle, Integer credit) {
		super();
		this.courseId = courseId;
		this.courseTitle = courseTitle;
		this.credit = credit;
	}
	public Course() {
		super();
	}
	
	
	
	
	
}
