# SpringBoot

This is my first experience with the Spring Framework. Using Amazon Web Services, I created a table of students, which
contains a unique id, their name, and the the course (major) they are studying. I followed the MVC pattern to allow for
searching by id, name, and course and to update the database with the usual removing, adding, and changing of values.

I also included a development and production configuration, which use a different database.

## Class Summary
**Student**
  Just a container for all the properties of a Student.
	
**StudentController**
	Handles the requests for data. Some examples below.
 
 http://localhost:8080/students
 http://localhost:8080/students/id/3
 
 The following would return all the students that fit the search.
 http://localhost:8080/students/name/George
 http://localhost:8080/students/course/Computer Science   

**StudentDao**
  An interface to be used with your choice of data storage/access.
  ex. MonogoDB, MySQL, or local data.
  
**FakeStudentDataImpl**
	Extends StudentDao, contains local data for students stored in a HashMap.
  
**MySqlStudentDataImpl**
	Extends StudentDao, can access any MySQL database with a table named "students".
  
**StudentService**
	Business logic.
