package gr.opensourceuom.presentation.course;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceDB implements CourseService {

    private final CourseRepository courseRepository;

    public CourseServiceDB(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.findById(id).orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public Course getCourseByName(String name) {
        return courseRepository.findByName(name).orElseThrow(CourseNotFoundException::new);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    @Override
    public Course updateCourse(Long id, Course updatedCourse) {
        Course courseById = getCourseById(id);

        courseById.setName(updatedCourse.getName() != null ? updatedCourse.getName() : courseById.getName());
        courseById.setEcts(updatedCourse.getEcts() != 0 ? updatedCourse.getEcts() : courseById.getEcts());

        return courseRepository.save(courseById);
    }

    @Override
    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }
}
