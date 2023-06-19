package com.example.demo.serviceimp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.module.Employee;
import com.example.demo.repo.EmployeeRepo;
import com.example.demo.service.EmployeeService;

@Service
public class EmployeeServiceImp  implements EmployeeService
{
	@Autowired
	EmployeeRepo repo;

	@Override
	public Employee addEmplooyee(Employee e) {
		return repo.save(e);
	}

	@Override
	public Employee empById(Integer eid) {
		return repo.findById(eid).orElseThrow(()-> new ResourceNotFoundException("Employee","id",eid));
		//		return null;
	}
	//	public List<Employee> empByDesgnation(String Designation)
	//	{
	//		return repo.findByDedignation(designation);
	//	}

	@Override
	public List<Employee> emplessSal(Double sal) {

		return repo.empByLessSal(sal);
	}

	@Override
	public Employee updateEmployee(Employee e) {
		Employee e1=repo.findById(e.getEid()).orElse(null);
		if(e1!=null)
		{
			e1.setEname(e.getEname());
			e1.setPhno(e.getPhno());
			e1.setSal(e.getSal());
			return repo.save(e1);
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "Id", e.getEid());
		}
	}
	@Override
	public Employee deleteEmployee(Integer eid) {
		Employee e=repo.findById(eid).orElse(null);
		if(e!=null)
		{
			repo.deleteById(eid);
			return e;
		}
		else
		{
			throw new ResourceNotFoundException("Employee", "Id", eid);
		}
	}
}
