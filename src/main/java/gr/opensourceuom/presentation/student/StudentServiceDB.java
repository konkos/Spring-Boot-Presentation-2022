package gr.opensourceuom.presentation.student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service("studentServiceDB")
public class StudentServiceDB implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceDB(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(new Student());
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student getStudentByLastName(String lastName) {
        return studentRepository.findByLastName(lastName).orElse(new Student());
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Student studentById = getStudentById(id);
        if (studentById.getLastName() == null) return new Student();

        studentById.setFirstName(student.getFirstName() != null ? student.getFirstName() : studentById.getFirstName());
        studentById.setLastName(student.getLastName() != null ? student.getLastName() : studentById.getLastName());
        return studentRepository.save(studentById);
    }
}
