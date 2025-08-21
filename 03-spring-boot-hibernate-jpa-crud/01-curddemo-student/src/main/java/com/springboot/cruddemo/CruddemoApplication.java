package com.springboot.cruddemo;

import com.springboot.cruddemo.dao.StudentDAO;
import com.springboot.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {

        return runner-> {
            // createStudent(studentDAO);

            // createMultipleStudent(studentDAO);

            // readStudent(studentDAO);

            // queryForStudents(studentDAO);

            // queryForStudentsByLastName(studentDAO);

            // updatestudent(studentDAO);

            deleteStudent(studentDAO);
        };
    }

    private void deleteStudent(StudentDAO studentDAO){

        //delete the student
        int studentId = 8;
        System.out.println("Deleting student id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updatestudent(StudentDAO studentDAO){

        // retrieve student based on the id: primary key
        int studentId = 1;
        System.out.println("Getting student with id: " + studentId);
        Student myStudent = studentDAO.findById(studentId);

        // change first name to "Scooby"
        System.out.println("Updating student ...");
        myStudent.setFirstname("Scooby");

        // update the student
        studentDAO.update(myStudent);

        // display updated student
        System.out.println("Updated student: " + myStudent);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {

        // get a list of students
        List<Student> theStudents = studentDAO.findByLastName("Duck");

        // display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }


    private void queryForStudents(StudentDAO studentDAO){

        //get a list of students
        List<Student> theStudents = studentDAO.findAll();

        //display list of students
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }

    private void readStudent(StudentDAO studentDAO) {

        // create a student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Daffy","Duck","daffy@yahoo.com");

        // save the student
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("Saved student. Generated id: " + theId);

        // retrieve student based on the id: primary key
        System.out.println("Retrieving student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        // display student
        System.out.println("Found the student: " + myStudent);
    }

    private void createMultipleStudent(StudentDAO studentDAO) {

        // create multiple students
        System.out.println("Creating new student object ...");
        Student tempStudent1 = new Student("John","Doe","john@yahoo.com");
        Student tempStudent2 = new Student("Mary","Public","mary@yahoo.com");
        Student tempStudent3 = new Student("Bonita","Applebum","bonita@yahoo.com");

        // save the student objects
        System.out.println("Saving the students ...");
        studentDAO.save(tempStudent1);
        studentDAO.save(tempStudent2);
        studentDAO.save(tempStudent3);
    }

    private void createStudent(StudentDAO studentDAO) {

        // create the student object
        System.out.println("Creating new student object ...");
        Student tempStudent = new Student("Paul","Doe","paul@yahoo.com");

        // save the student object
        System.out.println("Saving the student ...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student. Generated id: " + tempStudent.getId());
    }
}
