package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.MakeCarEntity;
import ru.repository.CarsEntityRepository;
import java.util.List;
@Service
public class CarService {
    @Autowired
    CarsEntityRepository carsEntityRepository;
    public List<MakeCarEntity> carsList() { return carsEntityRepository.findAll(); }
    public MakeCarEntity car(long id) { return carsEntityRepository.findByNumer( id); }
}
