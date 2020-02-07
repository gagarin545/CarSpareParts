package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.GroupPartsEntity;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;

import java.util.List;

public interface GroupPartsEntityRepository extends JpaRepository<GroupPartsEntity, Long> {
    @Query("select b from GroupPartsEntity b where b.id_group = :group")
    GroupPartsEntity findByNumer(@Param("group") long group);

}
