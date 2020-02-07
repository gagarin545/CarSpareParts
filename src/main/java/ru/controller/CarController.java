package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.service.CarService;
import ru.service.ModelService;

import java.util.List;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    CarService carService;
    @Autowired
    ModelService modelService;
    @GetMapping
    public ModelAndView list() {
        List<MakeCarEntity> carEntities = carService.carsList();
        System.out.println("count=" + carEntities.size());
        return new ModelAndView("CarList", "parcels", carEntities);

    }
    @GetMapping(value="/model/{id}")
    public ModelAndView view(@PathVariable Long id) {

        List<ModelCarEntity> model = modelService.modelList( carService.car( id));

        System.out.println("model=" + model.size());
        if ( model == null) {
            return new ModelAndView("CarList", HttpStatus.NOT_FOUND);
        }
        return new ModelAndView("ModelList", "parcels", model);
    }
}
