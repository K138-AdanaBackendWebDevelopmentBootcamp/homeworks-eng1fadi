package de.patika.school_project.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Table(name = "student")
@Data
@Entity
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@SequenceGenerator(name = "student",sequenceName = "STUDENT_SEQ_ID")
    private int id;
    private String name;
    private String address;
    private String gender;
    //@Column(name = "birth_date")
    private LocalDate birth_date;

    public Student(String name, String address, String gender, LocalDate birth_date) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birth_date = birth_date;
    }



    @JsonBackReference
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Course.class,cascade = CascadeType.ALL)
    private List<Course> studentCourseList =new ArrayList<>();


}
