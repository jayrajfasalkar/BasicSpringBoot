package net.javaguides.springboot.controller;

import jakarta.annotation.Resource;
import net.javaguides.springboot.bean.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("student")
public class StudentController {

    //http://localhost:8080/student
//    @GetMapping("/student")
//    public Student getstudent(){
//        return new Student(1,"Ramesh", "xyz");
//    }

    //above code using ResponseEntity class
    @GetMapping("/student")
    public ResponseEntity<Student> getStudent(){
        Student student = new Student(5, "ramesh", "tendlya");
        //return new ResponseEntity<>(student, HttpStatus.OK);
        //return ResponseEntity.ok(student);
        return ResponseEntity.ok().header("custom-header", "tendlyaaaaaaaa").body(student);
    }


    //http://localhost:8080/get-students
    @GetMapping("/get-students")
    public List<Student> getstudents(){
        Student s1 = new Student(1,"Ramesh", "xyz");
        Student s2 = new Student(2,"Suresh", "xyz");

        List<Student> students = new ArrayList<Student>();
        students.add(s1);
        students.add(s2);
        return students;
    }

    //Spring boot rest api with path variable
    //http://localhost:8080/students/id=2/fname=Nitya/lname=Dyuthi
    @GetMapping("/students/{id}/{fname}/{lname}")
    public Student studentpathvariable(@PathVariable("id") int studentid,
                                       @PathVariable() String fname,
                                       @PathVariable String lname){
        return new Student(studentid,fname, lname);
    }

    //Spring boot rest api with request parameter
    //http://localhost:8080/students/query?id=1&firstname=Nitya&lastname=Dyuthi
    @GetMapping("/students/query")
    public Student studentrequestvariable(@RequestParam int id,
                                          @RequestParam String firstname,
                                          @RequestParam String lastname){
        return new Student(id,firstname, lastname);
    }

    //spring boot rest api that handles HTTP POST request-- used to create new data
    // requestbody converts json object to a java object
    @PostMapping("/student/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createstudent(@RequestBody Student student){
        System.out.println(student.getId());
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }

    //spring boot rest api that handles HTTP PUT request-- used for updating existing data
    @PutMapping("/student/{id}/update")
    public Student updatestudent(@RequestBody Student student, @PathVariable int id){
        System.out.println(student.getFirstname());
        System.out.println(student.getLastname());
        return student;
    }

    //spring boot REST api that handles HTTP DELETE request-- used for deleting existing data
    @DeleteMapping("/student/{id}/delete")
    public String deleteStudent(@PathVariable int id){
        return "Student deleted successfully";
    }





















}
