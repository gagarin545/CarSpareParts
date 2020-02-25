package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.EditReference;
import ru.entity.MakeCarEntity;
import ru.service.CarService;
import java.util.List;
import java.util.Map;

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
       // List<MakeCarEntity> carEntities = carService.carsList();
        EditReference editReference = new EditReference();
        // System.out.println("countent=" + carEntities.size());
        return new ModelAndView("CarForm", "cars", editReference);
    }
    @PostMapping("/edit")
    public String edit(@RequestParam Map<String, String> map) {
        System.out.println( map.get("car"));
        //car.getCar_name().toUpperCase());
        //if( carService.carName(car.getCar_name().toUpperCase()) == null)
         //   carService.carAdd( car);
        return "redirect:/car/CarForm";
    }

}
