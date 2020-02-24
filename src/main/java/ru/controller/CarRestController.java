package ru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.entity.GroupPartsEntity;
import ru.entity.ModelCarEntity;
import ru.entity.PartsEntity;
import ru.entity.SparePartsEntity;
import ru.service.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class CarRestController {
    @Autowired
    CarService carService;
    @Autowired
    ModelService modelService;
    @Autowired
    GroupService groupService;
    @Autowired
    SpareService spareService;
    @Autowired
    PartServise partServise;
    @GetMapping(value="id_model/model/{id}")
    public List<ModelCarEntity> viewModel(@PathVariable Long id) {
        List<ModelCarEntity> models = null;
        models = modelService.modelList( carService.car( id));
        System.out.println("model =" + models.size());
        return models;
    }
    @GetMapping(value="id_group/{id}")
    public List<GroupPartsEntity> viewGroup(@PathVariable Long id) {
        List<GroupPartsEntity> groups = null;
        groups = groupService.groupList();
        System.out.println("group =" + groups.size());
        return groups;
    }
    @GetMapping(value="id_spare/{id}")
    public List<SparePartsEntity> viewSpare(@PathVariable Long id) {
        List<SparePartsEntity> spares = null;
        GroupPartsEntity group = groupService.group( id);
        spares = spareService.spareList( group);
        System.out.println(group.getGroup_name() + " spare =" + spares.size());
        return spares;
    }
    @GetMapping(value="id_part/{id}")
    public List<PartsEntity> viewParts(@PathVariable Long id) {
        List<PartsEntity> parts = null;
        SparePartsEntity spare = spareService.spare( id);
        ModelCarEntity model = modelService.model( id);
        parts =partServise.part( model, spare );
        System.out.println( ">>" + model.getModel_name() + "|" + spare.getSpare_name());
        return parts;
    }
}

