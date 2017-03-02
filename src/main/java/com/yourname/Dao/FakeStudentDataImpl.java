package com.yourname.Dao;

import com.yourname.Entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * Contains local data for students stored in a HashMap.
 *
 * Created by David on 2/27/2017.
 */
@Repository
@Qualifier("fakeData")
public class FakeStudentDataImpl implements StudentDao {

    private static Map<Integer, Student> students;

    static {

        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1,"Bob", "Computer Science"));
                put(2, new Student(2,"Alex", "Finance"));
                put(3, new Student(3,"Jane", "Math"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents() {
        return this.students.values();
    }

    @Override
    public Student getStudentById(int id) {
        return this.students.get(id);
    }

    /**
     * Unimplimented.
     *
     * @param name
     * @return
     */
    @Override
    public Collection<Student> getStudentsByName(String name) { return null; }

    /**
     * Unimplimented.
     *
     * @param course
     * @return
     */
    @Override
    public Collection<Student> getStudentsByCourse(String course) { return null; }

    @Override
    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    @Override
    public void updateStudent(Student student) {
        Student s = students.get(student.getId());
        s.setCourse(student.getCourse());
        s.setName(student.getName());
    }

    @Override
    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
