package pak2;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Collections;


@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "course",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course",sequenceName = "COURSE_SEq_ID")
    @Column(name = "course_id")
    private int id;
    private String cname;
    private String ccode;
    private double cScore;

    public Course() {
    }

    //public void setId(int id) {
    //    this.id = id;
    //}

    public int getId() {
        return id;
    }

    public Instructor getInstructor(Object o) {
        return instructor;
    }


    @ManyToMany(targetEntity = Student.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(nullable = false)
    private List<Student> students;
    public void setStudentList(List<Student> studentList) {
        this.students = studentList;
    }
    public List<Student> getStudentList() {
        return students;
    }

    public Course(String cname, String ccode, double cScore) {
        this.cname = cname;
        this.ccode = ccode;
        this.cScore = cScore;
    }
    public void setStudent(Student... students) {
        Collections.addAll(this.students,students);
        for(Student student:students)
            student.getCourseList().add(this);
    }
    @ManyToOne(targetEntity = Instructor.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Instructor instructor;

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCname() {
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public double getcScore() {
        return cScore;
    }

    public void setcScore(double cScore) {
        this.cScore = cScore;
    }

    public Course(String cname, String ccode, double cScore, Instructor instructor,Student students) {
        this.cname = cname;
        this.ccode = ccode;
        this.cScore = cScore;
        this.instructor = instructor;
        this.students= (List<Student>) students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return ccode.equals(course.ccode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ccode);
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", cScore=" + cScore +
                '}';
    }
}

/*
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cname;
    private String ccode;
    private double cScore;
    //@ManyToOne

    public Course() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Instructor getInstructor() {
        return instructor;
    }

    @ManyToMany
    private List<Student> studentList=new ArrayList<>();

    public List<Student> getStudentList() {
        return studentList;
    }

    public Course(String cname, String ccode, double cScore) {
        this.cname = cname;
        this.ccode = ccode;
        this.cScore = cScore;
    }
    @ManyToMany(mappedBy = "courseList")
    private List<Course> courseList=new ArrayList<>();
    public void setStudentList(List<Student> studentList) {
        this.courseList = courseList;
    }
    /*@ManyToMany(mappedBy = "courseList")
    private List<Student> studentList=new ArrayList<>();
    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
    public List<Course> getCourseList() {return courseList; }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    public Course(List<Course> courseList) {
        this.courseList = courseList;
    }



    @ManyToOne
    private Instructor instructor;

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public String getCname() {
        return cname;
    }


    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCcode() {
        return ccode;
    }

    public void setCcode(String ccode) {
        this.ccode = ccode;
    }

    public double getcScore() {
        return cScore;
    }

    public void setcScore(double cScore) {
        this.cScore = cScore;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", cScore=" + cScore +
                '}';
    }
}*/