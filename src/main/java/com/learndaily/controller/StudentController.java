package com.learndaily.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learndaily.Entity.Student;
import com.learndaily.service.Impl.StudentServiceImplementation;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	@Autowired
private StudentServiceImplementation service;
	//url: http://localhost:8080/api/student
	//add List student student
     @PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody List<Student> student)
	{
		service.saveStudents(student);
		return new ResponseEntity<String>("Student added Sucessfully",HttpStatus.CREATED);
		
	}
    //Build Rest API to getAll students
     @GetMapping("/allStudents")
     public List<Student> getAllStudents()
     {
    	return service.getAllStudents() ;
     }
    
  //Build Rest APi to get Student by ID
     @GetMapping("/{id}")
     public Student getStudentById(@PathVariable("id") Integer id)
     {
    	  return service.getStudentById(id);
     }
    //Rest API to Update the records
     @PutMapping("/update/{id}")
     public Student updateStudentInfo(@RequestBody Student student,@PathVariable("id") Integer id)
     {
    	 return service.updateStudentDetails(student, id);
     }
}
