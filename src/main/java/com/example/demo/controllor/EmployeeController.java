package com.example.demo.controllor;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.module.Employee;
import com.example.demo.service.EmployeeService;

//@Controller
//@ResponseBody
@RestController
public class EmployeeController {

	@Autowired
	EmployeeService service;
	@PostMapping("/addEmployee")
	ResponseEntity<Employee> addEmployee(@RequestBody Employee e)
	{
		return new ResponseEntity<Employee>(service.addEmplooyee(e), HttpStatus.CREATED);
	}
	
//	localhost:8080/employeeByEid
	@GetMapping("/employeeByEid")
	ResponseEntity<Employee> employeeByID(@RequestParam Integer eid)
	{
		return new ResponseEntity<Employee>(service.empById(eid),HttpStatus.FOUND);
	}
//	localhost:8080/employeeBySal
	@GetMapping("/employeeBySal")
	ResponseEntity<List<Employee>> employeeByLessSal(@RequestHeader Double sal)
	{
		return new ResponseEntity<List<Employee>>(service.emplessSal(sal),HttpStatus.FOUND);
	}
	
	@PutMapping("/updateEmp")
	ResponseEntity<Employee> updateEmp(@RequestBody Employee e)
	{
		return new ResponseEntity<Employee>(service.updateEmployee(e),HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteEmp")
	ResponseEntity<Employee>updateEmp(@RequestParam Integer eid)
	{
		return new ResponseEntity<Employee>(service.deleteEmployee(eid),HttpStatus.OK);
	}
}








