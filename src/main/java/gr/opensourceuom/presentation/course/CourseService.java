package gr.opensourceuom.presentation.course;

import java.util.List;

public interface CourseService {

    List<Course> getAllCourses();

    Course getCourseById(Long id);

    Course getCourseByName(String name);

    void deleteCourse(Long id);

    Course updateCourse(Long id, Course updatedCourse);

    Course addCourse(Course course);
}
