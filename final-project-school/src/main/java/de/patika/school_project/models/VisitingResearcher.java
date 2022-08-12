package de.patika.school_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class VisitingResearcher extends Instructor {

    private double hSalary;

    public VisitingResearcher(String name, String address, String phoneNo, Course c1, double hSalary) {
        super(name, address, phoneNo);
        this.hSalary = hSalary;
    }
}
