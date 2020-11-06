package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class GroupService {
    private final Group[] groups = new Group[6];
    @Autowired
    private StudentService studentService;

    public GroupService() {
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(i + 1, "第" + (i + 1) + "组", "", new ArrayList<>());
        }
    }

    public void updateGroupName(Integer id, String name) {
        if (id < 1 || id > groups.length) {
            throw new IllegalArgumentException("没有该组");
        }
        groups[id - 1].setName(name);
    }

    public Group[] divideGroups() {
        for (Group group : groups) {
            group.getStudents().clear();
        }
        List<Student> students = studentService.getAllStudents(null);
        int j = 0;
        List<Student> copyStudents = new ArrayList<>();
        for (Student student : students) {
            copyStudents.add((Student) student.clone());
        }
        Collections.shuffle(copyStudents);
        for (Student student : copyStudents) {
            if (j >= 6) {
                j = 0;
            }
            groups[j].getStudents().add(student);
            j++;
        }
        return groups;
    }
}
