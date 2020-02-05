package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.SparePartsEntity;

public interface SparePartsEntityRepository extends JpaRepository<SparePartsEntity, Long> {
}
