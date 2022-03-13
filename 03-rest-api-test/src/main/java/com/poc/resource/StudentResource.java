package com.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.poc.entity.Student;
import com.poc.service.StudentService;

@RestController
public class StudentResource {

	@Autowired
	private StudentService studentService;

	@PostMapping("/addStudent")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		boolean isSaved = studentService.addStudent(student);
		String msg = null;
		if (isSaved) {
			msg = "book saved successfully saved";
			return new ResponseEntity<>(msg, HttpStatus.OK);
		} else {
			msg = "book not saved!!";
		}
		return new ResponseEntity<>(msg, HttpStatus.BAD_REQUEST);

	}

}
