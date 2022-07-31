package models;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;


@Entity
public class Course {
    @Id
    @GeneratedValue(generator = "course",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "course",sequenceName = "COURSE_SEq_ID",allocationSize = 0,initialValue = 1)
    private int id;
    private String cname;
    private String ccode;
    private double cScore;

    @ManyToMany(targetEntity = Student.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Student> students;
    @ManyToOne(targetEntity = Instructor.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JoinColumn(nullable = false)
    private Instructor instructor;


    public Course(String cname, String ccode, double cScore, Instructor instructor, List<Student> students) {
        this.cname = cname;
        this.ccode = ccode;
        this.cScore = cScore;
        this.instructor = instructor;
        this.students= students;
    }

    public Course() {
    }


    ////get&set
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public Instructor getInstructor(Object o) {
        return instructor;
    }
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }
    public String getCname() {
        return cname;
    }
    public List<Student> getStudents() {
        return students;
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


    public Course(String cname, String ccode, double cScore) {
        this.cname = cname;
        this.ccode = ccode;
        this.cScore = cScore;
    }
    public void setStudent(Student... students) {
        Collections.addAll(this.students,students);
        for(Student student:students)
            student.getStudentCourseList().add(this);
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
        final int prime=31;
        int result=1;
        result=prime*result+((ccode==null)?0:ccode.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "moduls.Course{" +
                "cname='" + cname + '\'' +
                ", ccode='" + ccode + '\'' +
                ", cScore=" + cScore +
                '}';
    }
}

