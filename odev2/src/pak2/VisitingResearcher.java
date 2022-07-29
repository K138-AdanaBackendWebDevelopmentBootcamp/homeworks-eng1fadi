package pak2;
import java.util.Objects;
import javax.persistence.Entity;
import java.util.List;
import java.lang.*;
import java.lang.ClassLoader;
import java.lang.Class;
@Entity
public class VisitingResearcher extends Instructor{
    private double hSalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String name, String address, String phoneNo, double hSalary) {
        super(name, address, phoneNo);
        this.hSalary=hSalary;
    }


    public double gethSalary() {
        return hSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Double.compare(that.hSalary, hSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hSalary);
    }

    public void sethSalary(double hSalary) {
        this.hSalary = hSalary;
    }

    @Override
    public String toString() {
        return "VisitingResearcher{" +
                "hSalary=" + hSalary +
                '}';
    }

}
