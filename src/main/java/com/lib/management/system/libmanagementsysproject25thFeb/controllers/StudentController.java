package com.lib.management.system.libmanagementsysproject25thFeb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.management.system.libmanagementsysproject25thFeb.models.Book;
import com.lib.management.system.libmanagementsysproject25thFeb.models.User;
import com.lib.management.system.libmanagementsysproject25thFeb.requests.CreateRequestBook;
import com.lib.management.system.libmanagementsysproject25thFeb.requests.CreateRequestStudent;
import com.lib.management.system.libmanagementsysproject25thFeb.services.BookService;
import com.lib.management.system.libmanagementsysproject25thFeb.services.StudentService;

import jakarta.validation.Valid;

@RestController
public class StudentController {

	
	@Autowired
	StudentService studentService;
	
	
	@PostMapping("/student")
	public void createStudent(@Valid @RequestBody CreateRequestStudent createRequestStudent) {
		studentService.createStudent(createRequestStudent.to());
	}
	
	@GetMapping("/student/all")
	public List<User> getStudents() {
	return	studentService.getStudents();
	}
	
	@GetMapping("/student/{studentId}")
	public User getStudentId(@PathVariable("studentId") int studentId ) {
		return studentService.getStudentId(studentId);
	}
	
	
	
}
