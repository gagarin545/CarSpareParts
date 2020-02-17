package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.GroupPartsEntity;
import ru.service.GroupService;

import java.util.List;

@Controller
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;
    @GetMapping(value="/{id}")
    public ModelAndView list() {
        return new ModelAndView("GroupList", "groups",  groupService.groupList());
    }
}
