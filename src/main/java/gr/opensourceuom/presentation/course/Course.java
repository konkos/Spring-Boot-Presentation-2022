package gr.opensourceuom.presentation.course;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.opensourceuom.presentation.registration.Registration;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id", nullable = false)
    private Long course_id;

    private String name;

    private int ects;

    @OneToMany(mappedBy = "course")
    @JsonIgnore
    private Set<Registration> registeredStudents;

}
