package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;

import java.util.List;

public interface ModelCarEntityRepository extends JpaRepository<ModelCarEntity, Long> {
    @Query("select b from ModelCarEntity b where b.makeCarEntity = :id")
    List<ModelCarEntity> findByAllModel(@Param("id") MakeCarEntity id);

    @Query("select b from ModelCarEntity b where b.id_model = :model")
    ModelCarEntity findByNumer(@Param("model") Long model) ;
}
