package models;

import javax.persistence.Entity;
import java.util.List;
import java.util.Objects;

@Entity
public class PermanentInstructor extends Instructor {
    private double fSalary;

    public PermanentInstructor() {
    }

    public PermanentInstructor(String name, String address, String phoneNo, List<Course> courseList, double fSalary) {
        super(name, address, phoneNo, courseList);
        this.fSalary = fSalary;
    }


    public double getfSalary() {
        return fSalary;
    }

    public void setfSalary(double fSalary) {
        this.fSalary = fSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PermanentInstructor that = (PermanentInstructor) o;
        return Double.compare(that.fSalary, fSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), fSalary);
    }

    @Override
    public String toString() {
        return "moduls.PermanentInstructor{" +
                "fSalary=" + fSalary +
                '}';
    }
}
