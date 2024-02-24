package com.dinesh.firstspringbootapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dinesh.firstspringbootapp.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{

//	@Query(value = "SELECT * FROM DEPARTMENT WHERE DEPARTMENT_NAME = ?1", nativeQuery = true)
	public List<Department> findByDepartmentNameIgnoreCase(String departmentName);
	
	public List<Department> findByDepartmentAddressIgnoreCase(String departmentAddress);
	
	public List<Department> findByDepartmentCodeIgnoreCase(String departmentCode);
	
	

}
