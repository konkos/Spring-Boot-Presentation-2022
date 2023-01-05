package gr.opensourceuom.presentation.registration;

import gr.opensourceuom.presentation.course.Course;
import gr.opensourceuom.presentation.student.Student;
import jakarta.persistence.*;

@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(name = "UniqueStudentCourse", columnNames = {"course_id", "student_id"})
        }
)
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private double grade;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    public Registration() {
    }

    public Registration(Student student, Course course) {
        this.student = student;
        this.course = course;
        this.grade = 0;
    }

    public long getId() {
        return id;
    }

    public Registration setId(long id) {
        this.id = id;
        return this;
    }

    public double getGrade() {
        return grade;
    }

    public Registration setGrade(double grade) {
        this.grade = grade;
        return this;
    }

    public Course getCourse() {
        return course;
    }

    public Registration setCourse(Course course) {
        this.course = course;
        return this;
    }

    public Student getStudent() {
        return student;
    }

    public Registration setStudent(Student student) {
        this.student = student;
        return this;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "id=" + id +
                ", grade=" + grade +
                ", course=" + course +
                ", student=" + student +
                '}';
    }
}
