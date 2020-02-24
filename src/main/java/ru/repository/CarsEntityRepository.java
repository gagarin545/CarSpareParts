package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.MakeCarEntity;
import ru.entity.ModelCarEntity;

import java.util.List;

public interface CarsEntityRepository extends JpaRepository<MakeCarEntity, Long > {
    @Query("select b from MakeCarEntity b where b.id = :id") MakeCarEntity findByNumer(@Param("id") long id);
    @Query("select b from MakeCarEntity b where upper( b.car_name) = :name") MakeCarEntity findByName(@Param("name") String name);
}
