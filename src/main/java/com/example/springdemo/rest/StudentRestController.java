package com.example.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	private List<Student> students = new ArrayList<>();

	// This will be called only once rather than for every request
	@PostConstruct
	private void loadData() {
		students.add(new Student("Akkas", "Ali"));
		students.add(new Student("Abdul", "Kuddus"));
		students.add(new Student("Motin", "Ali"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		// As we've already put Jackson as a dependency in our POM file, Spring will automatically convert this Java object to JSON
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		return students.get(studentId);
	}
}
