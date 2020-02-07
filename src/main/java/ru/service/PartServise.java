package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.GroupPartsEntity;
import ru.entity.ModelCarEntity;
import ru.entity.PartsEntity;
import ru.entity.SparePartsEntity;
import ru.repository.PartsEntityRepository;

import java.util.List;

@Service
public class PartServise {
    @Autowired
    PartsEntityRepository partsEntityRepository;
    public List<PartsEntity> part(ModelCarEntity model, GroupPartsEntity group, SparePartsEntity spare) { return partsEntityRepository}
}
