package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students = new ArrayList<>();

    public StudentService() {
        students.add(new Student(1, "a", "male", ""));
        students.add(new Student(2, "b", "male", ""));
        students.add(new Student(3, "c", "female", ""));
        students.add(new Student(4, "d", "female", ""));
        students.add(new Student(5, "e", "male", ""));
        students.add(new Student(6, "f", "female", ""));
    }

    public List<Student> addStudents(List<Student> students) {
        this.students.addAll(students);
        return this.students;
    }

    public void deleteStudentById(Integer id) {
        boolean hasId = false;
        Student removedStudent = new Student();
        for (Student student : this.students) {
            if (student.getId().equals(id)) {
                hasId = true;
                removedStudent = student;
                break;
            }
        }
        if (!hasId) {
            throw new IllegalArgumentException("没有这个学生");
        }
        this.students.remove(removedStudent);
    }

    public List<Student> getAllStudents(String gender) {
        if (gender == null) {
            return this.students;
        }
        List<Student> students = new ArrayList<>();
        for (Student student : this.students) {
            if (student.getGender().equals(gender)) {
                students.add(student);
            }
        }
        return students;
    }

    public Student getStudentById(Integer id) {

        return null;
    }
}
