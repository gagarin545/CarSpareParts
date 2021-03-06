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
        models.forEach(x-> System.out.println(x.getModel_name() + "|" + x.getId_model()));
        return models;
    }
    @GetMapping(value="id_group/{id}")
    public List<GroupPartsEntity> viewGroup(@PathVariable Long id) {
        List<GroupPartsEntity> groups = null;
        groups = groupService.groupList();
        groups.forEach(x-> System.out.println(x.getGroup_name() + "|" +  x.getId_group()));
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
    @GetMapping(value="id_part/{id_spare}")
    public List<PartsEntity> viewParts(@PathVariable String id_spare) {
        List<PartsEntity> parts = null;
        String[] s = id_spare.split("&");
        if(!id_spare.contains("undefined"))
            parts = partServise.part(modelService.model(Long.parseLong( s[1])), spareService.spare(Long.parseLong( s[0])));
        return parts;
    }
    @GetMapping(value="part/{id_spare}")
    public PartsEntity viewPart(@PathVariable String id_spare) {
        PartsEntity part = null;
        System.out.print(id_spare);
        return part;
    }
}

