package net.ak.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.ak.springboot.bean.Student;

@RestController
public class StudentController {

	// http://localhost:8080/student
	@GetMapping("student")
	public Student getStudent() {
		Student student = new Student(1, "Ramesh", "Fadatare");
		return student;
	}

	// http://localhost:8080/student
	@GetMapping("students")
	public List<Student> getStudents() {
		List<Student> students = new ArrayList<>();
		students.add(new Student(1, "Ramesh", "Fadatare"));
		students.add(new Student(2, "Umesh", "Fadatare"));
		students.add(new Student(3, "Ram", "Jadhav"));
		students.add(new Student(4, "Sanjay", "Pawar"));

		return students;
	}

	// Spring boot REST API with PATH Variable
	// {id} - URI template variable
	// http://localhost:8080/students/1
	@GetMapping("students/{id}/{fname}/{lname}")
	public Student studentPathVariable(@PathVariable("id") int stdId, @PathVariable("fname") String firstName,
			@PathVariable("lname") String lastName) {
		return new Student(stdId, firstName, lastName);
	}

	// Spring Boot REST API with Request Param
	// http://localhost:8080/students?id=1&fname=Aathik&lname=Musathik
	@GetMapping("students/query")
	public Student studentRequestVariable(@RequestParam int id, @RequestParam String fname,
			@RequestParam String lname) {
		return new Student(id, fname, lname);
	}

}
