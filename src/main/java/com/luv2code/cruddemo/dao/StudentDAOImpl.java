package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save methods
    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);

    }

    //implement findById method
    // no need transactional because we are not changing anything
    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    //implement findAll method
    //we find all students
    //no need transactional because we are not changing anything
    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student ", Student.class);
        return theQuery.getResultList();
    }

    //implement findByLastName method
    //we find all students with last name
    //no need transactional because we are not changing anything
    @Override
    public List<Student> findByLastName(String theLastName) {
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData", Student.class);

        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }
}

