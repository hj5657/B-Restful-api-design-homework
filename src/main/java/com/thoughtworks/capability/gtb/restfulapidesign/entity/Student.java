package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private Integer id;
    private String name;
    private String gender;
    private String note;

    @Override
    public Object clone() {
        Student student = new Student(id, name, gender, note);
        return student;
    }
}
