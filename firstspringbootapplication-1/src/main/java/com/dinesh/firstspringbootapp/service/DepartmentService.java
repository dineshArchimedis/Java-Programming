package com.dinesh.firstspringbootapp.service;

import java.util.List;

import com.dinesh.firstspringbootapp.entity.Department;
import com.dinesh.firstspringbootapp.exception.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public List<Department> fetchDepartmentByName(String departmentName);

	public List<Department> fetchDepartmentByAddress(String departmentAddress);

	public List<Department> fetchDepartmentByCode(String departmentCode);

}
