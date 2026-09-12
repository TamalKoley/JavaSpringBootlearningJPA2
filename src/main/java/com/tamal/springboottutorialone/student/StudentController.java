package com.tamal.springboottutorialone.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public  StudentController (StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getStudents(){
            return studentService.getStudentsService();

    }

    @PostMapping(path="/registerStudent")
    public void registerStudents(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path="/updateStudent/{studentId}")
    public void updateStudent(@RequestBody Student student ,@PathVariable("studentId") Long id ){
        studentService.updateStudent(student , id);
    }

}
