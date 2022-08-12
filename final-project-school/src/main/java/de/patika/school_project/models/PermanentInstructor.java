package de.patika.school_project.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@Entity
public class PermanentInstructor extends Instructor {
    private double fSalary;

    public PermanentInstructor(String name, String address, String phoneNo, double fSalary) {
        super(name, address, phoneNo);
        this.fSalary = fSalary;
    }

}
