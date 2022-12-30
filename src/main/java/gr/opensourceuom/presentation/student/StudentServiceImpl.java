package gr.opensourceuom.presentation.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentServiceImpl")
public class StudentServiceImpl implements StudentService {

    private final List<Student> students;

    public StudentServiceImpl() {
        this.students = new ArrayList<>();
    }

    public List<Student> getAllStudents() {
        return students;
    }

    public Student getStudentById(Long id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst().orElse(new Student());
    }

    public Student getStudentByLastName(String lastName) {
        return students.stream().filter(student -> student.getLastName().equals(lastName)).findFirst().orElse(new Student());
    }

    @Override
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public void deleteStudentById(Long id) {
        Student studentById = getStudentById(id);
        students.remove(studentById);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student studentById = getStudentById(id);
        if (studentById.getLastName() == null) return studentById;

        studentById.setFirstName(student.getFirstName() != null ? student.getFirstName() : studentById.getFirstName());
        studentById.setLastName(student.getLastName() != null ? student.getLastName() : studentById.getLastName());
        return studentById;
    }


}
