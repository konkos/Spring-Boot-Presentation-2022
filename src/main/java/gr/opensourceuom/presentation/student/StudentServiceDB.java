package gr.opensourceuom.presentation.student;

import gr.opensourceuom.presentation.course.Course;
import gr.opensourceuom.presentation.registration.Registration;
import gr.opensourceuom.presentation.registration.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("studentServiceDB")
public class StudentServiceDB implements StudentService {

    private final StudentRepository studentRepository;

    private final RegistrationRepository registrationRepository;

    public StudentServiceDB(StudentRepository studentRepository, RegistrationRepository registrationRepository) {
        this.studentRepository = studentRepository;
        this.registrationRepository = registrationRepository;
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

    @Override
    public List<Course> getCourseByStudent(Long studentId) {
        Student studentById = getStudentById(studentId);
        List<Registration> coursesByStudent = registrationRepository.findCoursesByStudent(studentId);
        List<Course> courses = new ArrayList<>();

        for (Registration registration : coursesByStudent) {
            courses.add(registration.getCourse());
        }
        return courses;
    }
}
