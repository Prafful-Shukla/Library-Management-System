  package com.lib.management.system.libmanagementsysproject25thFeb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lib.management.system.libmanagementsysproject25thFeb.dao.StudentRepo;
import com.lib.management.system.libmanagementsysproject25thFeb.models.User;

@Service
public class StudentService {

	@Autowired
	StudentRepo studentRepo;

	public void createStudent(User user) {

		studentRepo.save(user);
	}

	public List<User> getStudents() {

		return studentRepo.findAll();
	}

	public User getStudentId(int studentId) {

		return studentRepo.findById(studentId).orElse(null);
	}

}
