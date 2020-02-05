package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.ModelCarEntity;

public interface ModelCarEntityRepository extends JpaRepository<ModelCarEntity, Long> {
}
