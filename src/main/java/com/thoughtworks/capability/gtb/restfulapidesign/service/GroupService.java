package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GroupService {
    private final Group[] groups = new Group[6];

    public GroupService() {
        for (int i = 0; i < groups.length; i++) {
            groups[i] = new Group(i + 1, "第" + (i + 1) + "组", "", new ArrayList<>());
        }
    }

    public void updateGroupName(Integer id, String name) {
        if (id < 1 || id > groups.length) {
            throw new IllegalArgumentException("没有该组");
        }
        groups[id-1].setName(name);
    }

    public Group[] divideGroups() {

        return new Group[0];
    }
}
