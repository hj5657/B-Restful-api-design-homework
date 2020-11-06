package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.Group;
import com.thoughtworks.capability.gtb.restfulapidesign.service.GroupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GroupController {
    private final GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PatchMapping("/groups/{id}")
    public ResponseEntity<Void> updateGroupName(@PathVariable Integer id,
                                                @RequestBody String name) {
        groupService.updateGroupName(id, name);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/groups")
    public ResponseEntity<Group[]> getGroupsOfDivide() {
        Group[] groups = groupService.divideGroups();
        return ResponseEntity.ok(groups);
    }
}
