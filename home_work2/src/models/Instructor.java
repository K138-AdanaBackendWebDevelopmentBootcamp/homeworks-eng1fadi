package models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Instructor {

    @Id
    @GeneratedValue(generator = "instructor",strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "instructor",sequenceName = "INSTRUCTOR_SEq_ID")
    private int id;
    private String name;
    private String address;
    private String phoneNo;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,targetEntity = Instructor.class)
    private Instructor instructor;

    public Instructor() {
    }
    @OneToMany(targetEntity = Course.class,fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Course>courseList;



    public Instructor(String name, String address, String phoneNo, List<Course> courseList) {
        this.name = name;
        this.address = address;
        this.phoneNo = phoneNo;
        this.courseList = courseList;

    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    //get&set
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }
    public void setCourseList(List<Course> courseList) {
        if (courseList.size()>0){
            this.courseList = courseList;
        }


    }
    public List<Course> getCourseList() {
        return courseList;
    }
/////


    private void setCourseInstructor(Course... courseList){
        for (Course course: courseList) {
            course.setInstructor(this);
        }
    }

    public void setCourse(Course... courses) {
        outer:
        for (Course course : courses) {
            for (Course value : this.courseList) {
                if (Objects.equals(course.getCcode(), value.getCcode()))
                    continue outer;
            }
            this.courseList.add(course);
            course.setInstructor(this);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(id,that.id)&&name.equals(that.name)&&address.equals(that.address)&&phoneNo.equals(that.phoneNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNo);
    }

    @Override
    public String toString() {
        return "moduls.Instructor{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                '}';
    }
}
