package com.tamal.springboottutorialone.student;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }


    public List<Student> getStudentsService(){

       return  studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail=studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()){
            throw new IllegalStateException("Email already Exists");
        }else{
            studentRepository.save(student);
        }

    }

    public void deleteStudent(Long id) {
        boolean isExists = studentRepository.existsById(id);
        if (!isExists) {
            throw new IllegalStateException("Student with id " + id + " not exists !!");

        } else {
            studentRepository.deleteById(id);
        }

    }

    @Transactional
    public void updateStudent(Student student ,Long id) {

            Student foundStudent=studentRepository.findById(id).orElseThrow( ()->
                     new IllegalStateException("Student with id "+id+" not found")
            );

            foundStudent.setName(student.getName());
            foundStudent.setEmail(student.getEmail());

        }

    }






