package com.dinesh.firstspringbootapp.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dinesh.firstspringbootapp.entity.Department;
import com.dinesh.firstspringbootapp.exception.DepartmentNotFoundException;
import com.dinesh.firstspringbootapp.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService
{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

//	@Override
//	public Department fetchDepartmentById(Long departmentId) {
//		return departmentRepository.findById(departmentId).get();
//	}
	
	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department=departmentRepository.findById(departmentId);
		if(!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);
	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();
		
		if(Objects.nonNull(department.getDepartmentName())&&
		!"".equalsIgnoreCase(department.getDepartmentName())) {
			depDB.setDepartmentName(department.getDepartmentName());
		}
		if(Objects.nonNull(department.getDepartmentCode())&&
		!"".equalsIgnoreCase(department.getDepartmentCode())) {
			depDB.setDepartmentCode(department.getDepartmentCode());
		}
		if(Objects.nonNull(department.getDepartmentAddress())&&
		!"".equalsIgnoreCase(department.getDepartmentAddress())) {
			depDB.setDepartmentAddress(department.getDepartmentAddress());
		}
		return departmentRepository.save(depDB);
	}

	@Override
	public List<Department> fetchDepartmentByName(String departmentName) {
		return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
	}

	@Override
	public List<Department> fetchDepartmentByAddress(String departmentAddress) {
		return departmentRepository.findByDepartmentAddressIgnoreCase(departmentAddress);
	}

	@Override
	public List<Department> fetchDepartmentByCode(String departmentCode) {
		return departmentRepository.findByDepartmentCodeIgnoreCase(departmentCode);
	}

}
