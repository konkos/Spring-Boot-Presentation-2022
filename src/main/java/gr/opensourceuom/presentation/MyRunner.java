package gr.opensourceuom.presentation;

import gr.opensourceuom.presentation.course.Course;
import gr.opensourceuom.presentation.course.CourseRepository;
import gr.opensourceuom.presentation.registration.Registration;
import gr.opensourceuom.presentation.registration.RegistrationRepository;
import gr.opensourceuom.presentation.student.Student;
import gr.opensourceuom.presentation.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Component
public class MyRunner implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final RegistrationRepository registrationRepository;

    @Autowired
    public MyRunner(StudentRepository studentRepository, CourseRepository courseRepository, RegistrationRepository registrationRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
        this.registrationRepository = registrationRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("START RUNNER");

        saveStudentsToDB();

        saveCoursesToDB();

        saveRegistrationsToDB();

        System.out.println("END RUNNER");

    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
    private void saveRegistrationsToDB() throws Exception {

        if (registrationRepository.count() != 0) return;

        List<Course> allCourses = courseRepository.findAll();
        List<Student> allStudents = studentRepository.findAll();

        Random random = new Random();

        for (int i = 0; i < 20; i++) {

            try {
                Registration registration = new Registration();
                registration.setCourse(allCourses.get(random.nextInt(allCourses.size())));
                registration.setStudent(allStudents.get(random.nextInt(allCourses.size())));

//            if (i == 9) throw new Exception("RANDOM EXCEPTION");

                registrationRepository.save(registration);
            } catch (Exception e) {
                i--;
            }

        }

        System.out.println("END RUNNER");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    private void saveCoursesToDB() {
        if (courseRepository.count() != 0) return;
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setName("CourseName " + i);
            course.setEcts(5);
            courseRepository.save(course);
        }
    }

    @Transactional(noRollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
    private void saveStudentsToDB() {
        if (studentRepository.count() != 0) return;
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            student.setFirstName("FirstName " + i);
            student.setLastName("LastName " + i);
            studentRepository.save(student);
        }
    }
}