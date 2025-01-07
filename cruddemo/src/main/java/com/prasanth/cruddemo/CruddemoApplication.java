package com.prasanth.cruddemo;

import com.prasanth.cruddemo.dao.StudentDAO;
import com.prasanth.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {

		// Create the Student Object
		System.out.println("Creating new student object...");
		Student temStudent = new Student("Prasanth", "Thumma", "prathum@gmail.com");

		// Save the student Object
		System.out.println("Saving the Student...");
		studentDAO.save(temStudent);

		// Display the id of saved Student
		System.out.println("Saved student. Generated id: " + temStudent.getId());
	}
}
