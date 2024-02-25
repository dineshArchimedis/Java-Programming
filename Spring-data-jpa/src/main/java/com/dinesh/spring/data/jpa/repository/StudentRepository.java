package com.dinesh.spring.data.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dinesh.spring.data.jpa.entity.Student;

import jakarta.transaction.Transactional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>
{
	
//	List<Student> findByFirstName(String firstName);
//	
//	List<Student> findByFirstNameContaining (String name);
//	
//	List<Student> findByLastNameNotNull();
//	
//	List<Student> findByGuardinName (String guardianName);
//	
//	Student findByFirstNameAndLastName (String firstName, String lastName);
//	
//	//JPQL
//	@Query("select s from student s where s.emailId=?1 ")
//	Student getStudentByEmailAddress(String emailId);
//	
//	
//	//Native Query
//	@Query(value="SELECT * FROM schooldb.tbl_student s WHERE s.email_address=?1", nativeQuery=true)
//	Student getStudentByEmailAddressNative(String emailId);
//	
//	//Native Named Param
//	@Query(value="SELECT * FROM schooldb.tbl_student s WHERE s.email_address = :emailId", nativeQuery=true)
//	Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
//	
//	@Modifying
//	@Transactional
//	@Query(value="update tbl_student set first_name = ?1 where email_address=?2", nativeQuery=true)
//	int updateStudentNameByEmailId(String firstName, String emailId);
//	
}
