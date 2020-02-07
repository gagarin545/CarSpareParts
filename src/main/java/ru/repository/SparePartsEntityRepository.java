package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.entity.SparePartsEntity;

public interface SparePartsEntityRepository extends JpaRepository<SparePartsEntity, Long> {
    @Query("select b from SparePartsEntity b where b.id_spare = :spare")
    SparePartsEntity findByNumer(@Param("spare") long spare);
}
