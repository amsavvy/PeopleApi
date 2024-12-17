package com.analysis.savvy.controller;

import com.analysis.savvy.bean.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    @GetMapping("/student")
public Student getStudent(){
    Student st = new Student(1,"Savv","G");
    return st;
}

@GetMapping("/students")
public List<Student> getStudents(){
    List<Student> st = new ArrayList<>();
    st.add(new Student(2,"Sam","A"));
    st.add(new Student(3,"Peter","G"));
    st.add(new Student(4,"Dean","T"));

    return st;
    }


    // spring boot rest api with path variable

    @GetMapping("students/{id}/{first-name}/{last-name}")
    public Student studentPathVar( @PathVariable int id,
                                   @PathVariable("first-name") String ftName,
                                   @PathVariable("last-name") String ltName ){
        return new Student(id,ftName, ltName );
    }


    @GetMapping("students/query")
    public Student studentReqVar( @RequestParam int id){
        return new Student(id, "Akshay", "kumar");
}

// what is the difference




}
