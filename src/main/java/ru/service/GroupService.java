package ru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.entity.GroupPartsEntity;
import ru.entity.ModelCarEntity;
import ru.repository.GroupPartsEntityRepository;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupPartsEntityRepository groupPartsEntityRepository;
    public GroupPartsEntity group(long id) {  return groupPartsEntityRepository.findByNumer( id);    }
    public List<GroupPartsEntity> groupList() { return  groupPartsEntityRepository.findAll(); }
    //public GroupPartsEntity groupList(ModelCarEntity modelCarEntity) { return groupPartsEntityRepository.findByNumer( modelCarEntity); }
}
