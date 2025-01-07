package com.prasanth.cruddemo;

import com.prasanth.cruddemo.dao.StudentDAO;
import com.prasanth.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLOutput;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudent(studentDAO);
			readStudent(studentDAO);
		};
	}

	private void readStudent(StudentDAO studentDAO) {

		// Create a student object
		System.out.println("Creating a new Student Object");
		Student s1 = new Student("hello", "world!", "hello@world.com");

		// Save the student
		System.out.println("Saving the student data into Database....");
		studentDAO.save(s1);

		// Display id of the saved student
		System.out.println("Displaying the student data using the id: " + s1.getId());

		// Retrieve Student based on the id: primary key
		System.out.println("Retrieve Student based on the id: primary key -> " + s1.getId());
		Student myStudent = studentDAO.findById(s1.getId());


		// Display the Student
		System.out.printf("From the student: " + myStudent);
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// Create Multiple Students
		System.out.println("Creating 3 students object...");
		Student temStudent1 = new Student("Rajesh", "Thumma1", "raj@gmail.com");
		Student temStudent2 = new Student("Suresh", "Thumma2", "sur@gmail.com");
		Student temStudent3 = new Student("Akhilesh", "Thumma3", "akki@gmail.com");

		// Save the students Object
		System.out.println("Saving the 3 Students...");
		studentDAO.save(temStudent1);
		studentDAO.save(temStudent2);
		studentDAO.save(temStudent3);
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
