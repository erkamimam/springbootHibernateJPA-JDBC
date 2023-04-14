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
    public static void print(String s){
        System.out.println(s);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
        return runner -> {
            createStudent(studentDAO);


        };
    }

    private void createStudent(StudentDAO studentDAO) {
        //create a student object
        System.out.println("Creating new  student object");
        Student student=Student.builder()
                .firstName("erkam")
                .lastName("imamoglu")
                .email("erkam@gmail.com")
                .build();

        //save the student object
        System.out.println("Saving the student...");
        studentDAO.save(student);
        System.out.println(student.toString());


        //display the saved student object
        System.out.println("Saved student. Generated id: " + student.getId());
    }

}
