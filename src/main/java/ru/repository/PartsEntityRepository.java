package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.GroupPartsEntity;
import ru.entity.ModelCarEntity;
import ru.entity.PartsEntity;
import ru.entity.SparePartsEntity;

import java.util.List;

public interface PartsEntityRepository extends JpaRepository<PartsEntity, Long> {
    @Query("select b from PartsEntity b where b.modelCarEntity = :model  and b.sparePartsEntity = :spare")
    List<PartsEntity> findByNumer(@Param("model") ModelCarEntity model, @Param("spare")SparePartsEntity spare);

}
