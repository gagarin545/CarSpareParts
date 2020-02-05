package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.MakeCarEntity;
public interface CarsEntityRepository extends JpaRepository<MakeCarEntity, Long > {
}
