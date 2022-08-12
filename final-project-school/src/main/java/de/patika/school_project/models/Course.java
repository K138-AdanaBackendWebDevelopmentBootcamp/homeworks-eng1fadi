package de.patika.school_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
@Data
@RequiredArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cname;
    private String ccode;
    private double cscore;

    public Course(String cname, String ccode, double cscore) {
        this.cname = cname;
        this.ccode = ccode;
        this.cscore = cscore;
    }

    @JsonBackReference
    @ManyToMany(targetEntity = Student.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Student> students;
    @JsonBackReference
    @ManyToOne(targetEntity = Instructor.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private Instructor instructor;
}

