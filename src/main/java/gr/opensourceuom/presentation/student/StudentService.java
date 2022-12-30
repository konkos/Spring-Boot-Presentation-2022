package gr.opensourceuom.presentation.student;

import java.util.List;

public interface StudentService {

    Student getStudentById(Long id);

    List<Student> getAllStudents();

    Student getStudentByLastName(String lastName);

    Student addStudent(Student student);

    void deleteStudentById(Long id);

    Student updateStudent(Long id, Student student);
}
