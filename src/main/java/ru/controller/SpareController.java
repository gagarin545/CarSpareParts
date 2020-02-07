package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.GroupPartsEntity;
import ru.entity.SparePartsEntity;
import ru.service.GroupService;
import ru.service.SpareService;

import java.util.List;

@Controller
@RequestMapping("/spare")
public class SpareController {
    @Autowired
    SpareService spareService;
    @GetMapping(value="/{id}")
    public ModelAndView list() {
        List<SparePartsEntity> spareList = spareService.spareList();
        return new ModelAndView("SpareList", "parcels", spareList);
    }
}
