package pak2;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.lang.*;
import java.lang.ClassLoader;
import java.lang.Class;
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String gender;
    private LocalDate birthDate;


    public Student() {
    }
    public Student(String name,LocalDate birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

    public Student(String name, String address, String gender, LocalDate birthDate) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Course.class,cascade = CascadeType.ALL)
    private List<Course>courseList=new ArrayList<>();

    public List<Course>getCourseList() {return courseList;}

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthDate == student.birthDate && name.equals(student.name) && address.equals(student.address) && gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, gender, birthDate);
    }
    public void setCourse(Course... courses) {  // when we set a course to a student ,we add that student to the student list of this course
        for (Course course:courses) {
            courseList.add(course);
            course.getStudentList().add(this);
        }
    }
}
/*
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;
    private String gender;
    private LocalDate birthDate;


    public Student() {
    }
    public Student(String name,LocalDate birthDate){
        this.name = name;
        this.birthDate = birthDate;
    }

   // public void (List<Course> courseList) {
    //    this.courseList = courseList;
    //}


    public Student(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Student(String name, String address, String gender, LocalDate birthDate) {
        this.name = name;
        this.address = address;
        this.gender = gender;
        this.birthDate = birthDate;
    }
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Course>courseList=new ArrayList<>();
    public List<Course>getCourseList() {return courseList;}

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return birthDate == student.birthDate && name.equals(student.name) && address.equals(student.address) && gender.equals(student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, gender, birthDate);
    }
    public void setCourse(Course... courses) {  // when we set a course to a student ,we add that student to the student list of this course
        for (Course course:courses) {
            courseList.add(course);
            course.getStudentList().add(this);
        }
    }
}*/