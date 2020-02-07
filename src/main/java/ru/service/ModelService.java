package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;
import ru.repository.ModelCarEntityRepository;
import java.util.List;

@Service
public class ModelService {
    @Autowired
    ModelCarEntityRepository modelCarEntityRepository;
    public List<ModelCarEntity> modelList(MakeCarEntity id) { return modelCarEntityRepository.findByAllModel( id);}
    //public List<ModelCarEntity> modelList(MakeCarEntity id) { return modelCarEntityRepository.findByNumer(id);}
    public ModelCarEntity model(long id_model) { return modelCarEntityRepository.findByNumer( id_model);    }
}
