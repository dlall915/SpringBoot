package com.yourname.Dao;

import com.yourname.Entity.Student;

import java.util.Collection;

/**
 * An interface to be used with your choice of data storage.
 * ex. MonogoDB, MySQL, or local data.
 *
 * Created by David on 2/28/2017.
 */
public interface StudentDao {
    Collection<Student> getAllStudents();

    Student getStudentById(int id);

    void removeStudentById(int id);

    void updateStudent(Student student);

    void insertStudent(Student student);
}
