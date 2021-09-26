package com.learndaily.service;
import java.util.List;

import com.learndaily.Entity.Student;



public interface StudentService {
	
void saveStudents(List<Student> student);
List<Student> getAllStudents();
Student getStudentById(Integer id);
Student updateStudentDetails(Student student,Integer id);

	}


