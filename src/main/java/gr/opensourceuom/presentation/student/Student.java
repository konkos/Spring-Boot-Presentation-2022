package gr.opensourceuom.presentation.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import gr.opensourceuom.presentation.registration.Registration;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import java.util.Objects;
import java.util.Set;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_id", nullable = false)
    private Long student_id;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private Set<Registration> registrations;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return student_id != null && Objects.equals(student_id, student.student_id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
