package com.yourname.Controller;

import com.yourname.Entity.Student;
import com.yourname.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * Handles the requests for data. Some examples below.
 *
 * http://localhost:8080/students
 * http://localhost:8080/students/id/3
 *
 * The following would return all the students that fit the search.
 * http://localhost:8080/students/name/George
 * http://localhost:8080/students/course/Computer Science
 *
 * Created by David on 2/27/2017.
 */
@RestController
@RequestMapping("/students")
public class StudentController {

    //Find a bean of type studentService and inject it.
    @Autowired
    private StudentService studentService;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    /**
     * Doesn't check if there is actually a student's info in requested spot.
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable("id") int id) {
        return studentService.getStudentById(id);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Collection<Student> getStudentsByName(@PathVariable("name") String name) {
        return studentService.getStudentsByName(name);
    }

    @RequestMapping(value = "/course/{course}", method = RequestMethod.GET)
    public Collection<Student> getStudentsByCourse(@PathVariable("course") String name) {
        return studentService.getStudentsByCourse(name);
    }

    /**
     * Doesn't check if there is actually a student's info in requested spot.
     *
     * @param id
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentById(@PathVariable("id") int id) {
        studentService.removeStudentById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateStudent(@RequestBody Student student) {
        studentService.updateStudent(student);
    }

    /**
     * Currently overwrites.
     *
     * @param student
     */
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertStudent(@RequestBody Student student) {
        studentService.insertStudent(student);
    }
}
