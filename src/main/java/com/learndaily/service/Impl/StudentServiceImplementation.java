package com.learndaily.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learndaily.Entity.Student;
import com.learndaily.exception.ResourceNotFoundException;
import com.learndaily.repository.StudentRepository;
import com.learndaily.service.StudentService;
@Service
public class StudentServiceImplementation implements StudentService {
    @Autowired
	private StudentRepository repository;
	public void saveStudents(List<Student> student) {
		repository.saveAll(student);
		
	}
	
	public List<Student> getAllStudents() {
		
		return repository.findAll();
	}

	@Override
	public Student getStudentById(Integer id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student","Id",id));
//		if(optional.isPresent())
//		{
//		return optional.get();	
//		}
//		else
//		{
//			throw new ResourceNotFoundException("Employee","Id",id);
//		}
	}

	@Override
	public Student updateStudentDetails(Student student, Integer id) {
		Optional<Student> opt=repository.findById(id);
		if(opt.isPresent())
		{
			Student std=opt.get();//Existing Student details
			std.setFirstName(student.getFirstName()); //Updating the student details
			std.setLastName(student.getLastName());
			std.setEmail(student.getEmail());
			repository.save(std);
			return std;
		}
		else
		{
			throw new ResourceNotFoundException("Employee","Id",id);
		}
	}
	
	

}
