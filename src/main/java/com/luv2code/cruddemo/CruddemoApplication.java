package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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

    public static void print(String s) {
        System.out.println(s);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            //createStudent(studentDAO);
            createMultipleStudent(studentDAO);
            //readStudent(studentDAO);
            //queryForStudent(studentDAO);
            //queryForStudentByLastNames(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudent(studentDAO);
        };
    }

    private void deleteAllStudent(StudentDAO studentDAO) {
        System.out.println("Deleting all students");
        int numberOfDeletedStudents =studentDAO.deleteAll();
        System.out.println("Deleted row count: " + numberOfDeletedStudents);
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;
        System.out.println("Deleting student with id: " + studentId);
        studentDAO.delete(studentId);
    }

    private void updateStudent(StudentDAO studentDAO) {
        //retrieve student based on the id: primary key
        int studentId = 2;
        System.out.println("Getting student with id: " + studentId);

        Student student = studentDAO.findById(studentId);

        System.out.println("Updating student....");

        //change the first name to "Scooby"
        student.setFirstName("Scooby");
        studentDAO.update(student);
        System.out.println("Student updated: " + student.toString());


    }

    private void queryForStudentByLastNames(StudentDAO studentDAO) {
        //get list of students
        List<Student> theStudents = studentDAO.findByLastName("erkam");
        if (theStudents.isEmpty()) {
            System.out.println("No student found");
        } else {
            //display the students
            for (Student student : theStudents) {
                System.out.println(student.toString());
            }
        }

    }

    private void queryForStudent(StudentDAO studentDAO) {
        //get list of students
        List<Student> theStudents = studentDAO.findAll();

        //display the students
        for (Student student : theStudents) {
            System.out.println(student.toString());
        }

    }


    private void createMultipleStudent(StudentDAO studentDAO) {
        //create multiple students
        System.out.println("Creating multiple student object");
        Student student1 = Student.builder().firstName("ahmet").lastName("büyükates").email("ahmet@gmail.com").build();
        Student student2 = Student.builder().firstName("mehmet").lastName("ali").email("mehmet@gmail.com").build();
        Student student3 = Student.builder().firstName("ali").lastName("veli").email("ali@gmial.com").build();


        //create a student object
        System.out.println("Saving the students ...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());


    }

    private void createStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Creating new  student object");
        Student student = Student.builder()
                .firstName("ahmet")
                .lastName("büyükates")
                .email("ahemt@gmail.com")
                .build();

        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(student);
        System.out.println(student.toString());


        //display the saved student object
        System.out.println("Saved student. Generated id: " + student.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        //create the student object
        System.out.println("Creating new student object");
        Student student = Student.builder()
                .firstName("ahmet")
                .lastName("büyükates")
                .email("ahmet@gmail.com").build();

        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(student);

        //display the saved student object
        int theId = student.getId();
        System.out.println("Saved student. Generated id: " + theId);

        //retrieve student based on the id: primary key
        System.out.println("Getting student with id: " + theId);
        Student myStudent = studentDAO.findById(theId);

        //display the student
        System.out.println("Found the student: " + myStudent);


    }


}
