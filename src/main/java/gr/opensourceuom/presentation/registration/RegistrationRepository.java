package gr.opensourceuom.presentation.registration;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;

import java.util.List;

public interface RegistrationRepository extends JpaRepository<Registration, Long> {
    @Query("select r from Registration r where r.student.id = ?1")
    List<Registration> findCoursesByStudent(@NonNull long student_id);

    @Query("select r from Registration r where r.course.id = ?1")
    List<Registration> findStudentsByCourse(Integer course_id);
}