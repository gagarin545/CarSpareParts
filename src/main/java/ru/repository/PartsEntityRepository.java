package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.PartsEntity;

public interface PartsEntityRepository extends JpaRepository<PartsEntity, Long> {
    
}
