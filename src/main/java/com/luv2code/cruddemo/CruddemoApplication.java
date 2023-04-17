package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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


        };
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

}
