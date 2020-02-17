package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.MakeCarEntity;
import ru.service.CarService;
import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;
    @GetMapping
    public ModelAndView list(){
        return new ModelAndView("CarList", "cars", carService.carsList());
    }
    @GetMapping(value="/CarForm")
    public ModelAndView form() {
        List<MakeCarEntity> carEntities = carService.carsList();
        System.out.println("countent=" + carEntities.size());
        return new ModelAndView("TestForm", "parcels", carEntities);
    }
}
