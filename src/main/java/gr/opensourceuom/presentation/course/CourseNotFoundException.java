package gr.opensourceuom.presentation.course;

public class CourseNotFoundException extends RuntimeException {

    public CourseNotFoundException() {
        super("Course Not Found");
    }
}
