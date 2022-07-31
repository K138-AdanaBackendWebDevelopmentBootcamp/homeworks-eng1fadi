package dv.patika.work_3.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {
    @Id
    @GeneratedValue(generator = "student",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student",sequenceName = "STUDENT_SEQ_ID")
    private int id;
    private String name;
    private String address;
    private String gender;
    @Column(name = "birth_date")
    private LocalDate birthDate;
    @ManyToMany(fetch = FetchType.LAZY,targetEntity = Course.class,cascade = CascadeType.ALL)
    private List<Course> studentCourseList =new ArrayList<>();

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

    public List<Course> getStudentCourseList() {return studentCourseList;}

    public void setStudentCourseList(List<Course> studentCourseList) {
        this.studentCourseList = studentCourseList;
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
        return "moduls.Student{" +
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
            studentCourseList.add(course);
            course.getStudents().add(this);
        }
    }
}
