package com.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		
		students.add(new Student("Akkas", "Ali"));
		students.add(new Student("Abdul", "Kuddus"));
		students.add(new Student("Motin", "Ali"));
		
		// As we've already put Jackson as a dependency in our POM file, Spring will automatically convert this Java object to JSON
		return students;
	}
}
