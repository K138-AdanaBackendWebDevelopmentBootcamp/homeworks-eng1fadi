package de.patika.school_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public abstract class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "instructor",sequenceName = "INSTRUCTOR_SEq_ID")
    private int id;
    private String name;
    private String address;
    private String phoneNo;

    public Instructor(String name, String address, String phoneNo) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Instructor.class)
    private Instructor instructor;


    @JsonBackReference
    @OneToMany(targetEntity = Course.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Course>courseList;

}
