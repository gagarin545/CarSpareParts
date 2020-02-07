package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.GroupPartsEntity;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.entity.SparePartsEntity;
import ru.repository.SparePartsEntityRepository;

import java.util.List;

@Service
public class SpareService {
    @Autowired
    SparePartsEntityRepository sparePartsEntityRepository;
    public List<SparePartsEntity> spareList() { return sparePartsEntityRepository.findAll();}
    public SparePartsEntity spare(long id) { return sparePartsEntityRepository.findByNumer( id);}

}
