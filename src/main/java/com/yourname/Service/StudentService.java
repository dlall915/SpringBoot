package com.yourname.Service;

import com.yourname.Dao.StudentDao;
import com.yourname.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Business logic.
 *
 * Created by David on 2/27/2017.
 */
@Service
public class StudentService {

    //Find a bean of type studentDao and inject it.
    @Autowired
    //Since StudentDao is an interface, I specify which implementation. This allows use of any data storage simply
    //by changing the Qualifier.
    @Qualifier("mysql")
    private StudentDao studentDao;

    public Collection<Student> getAllStudents() {
        return this.studentDao.getAllStudents();
    }

    public Student getStudentById(int id) {
        return this.studentDao.getStudentById(id);
    }

    public Collection<Student> getStudentsByName(String name) { return this.studentDao.getStudentsByName(name); }

    public Collection<Student> getStudentsByCourse(String course) { return this.studentDao.getStudentsByCourse(course); }

    public void removeStudentById(int id) {
        this.studentDao.removeStudentById(id);
    }

    public void updateStudent(Student student) {
        this.studentDao.updateStudent(student);
    }

    public void insertStudent(Student student) {
        this.studentDao.insertStudent(student);
    }

}
