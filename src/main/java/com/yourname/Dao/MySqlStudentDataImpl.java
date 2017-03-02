package com.yourname.Dao;

import com.yourname.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * Accesses any MySQL database with a table named "students".
 *
 * Created by David on 2/28/2017.
 */
@Repository
@Qualifier("mysql")
public class MySqlStudentDataImpl implements StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * A Student object is created and it's properties are populated by the row in the database table.
     */
    private static class StudentRowMapper implements RowMapper<Student> {

        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student = new Student();
            student.setId(resultSet.getInt("id"));
            student.setName(resultSet.getString("name"));
            student.setCourse(resultSet.getString("course"));
            return student;
        }
    }

    @Override
    public Collection<Student> getAllStudents() {
        //SELECT column_name(s) FROM table_name
        final String sql = "SELECT id, name, course FROM students";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper());
        return students;
    }

    @Override
    public Student getStudentById(int id) {
        //SELECT column_name(s) FROM table_name WHERE column_name operator value
        final String sql = "SELECT id, name, course FROM students WHERE id = ?";
        Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(), id);
        return student;
    }

    @Override
    public Collection<Student> getStudentsByName(String name) {
        //SELECT column_name(s) FROM table_name WHERE column_name operator value
        final String sql = "SELECT id, name, course FROM students WHERE name = ?";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), name);
        return students;
    }

    @Override
    public Collection<Student> getStudentsByCourse(String course) {
        //SELECT column_name(s) FROM table_name WHERE column_name operator value
        final String sql = "SELECT id, name, course FROM students WHERE course = ?";
        List<Student> students = jdbcTemplate.query(sql, new StudentRowMapper(), course);
        return students;
    }

    /**
     * Use update when making changes to the table.
     *
     * @param id
     */
    @Override
    public void removeStudentById(int id) {
        //DELETE FROM table_name WHERE some_column = some_value
        String sql = "DELETE FROM students WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateStudent(Student student) {
        //UPDATE table_name
        //SET column1=value, column2=value2, ...
        //WHERE some_column=some_value
        final String sql = "UPDATE students SET name = ?, course = ? WHERE id = ?";
        final int id = student.getId();
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] {name, course, id});
    }

    @Override
    public void insertStudent(Student student) {
        //INSERT INTO table_name (column1, column2, column3, ...)
        //VALUES (value1, value2, value3, ...)
        final String sql = "INSERT INTO students (name, course) VALUES (?, ?)";
        final String name = student.getName();
        final String course = student.getCourse();
        jdbcTemplate.update(sql, new Object[] {name, course});
    }
}
