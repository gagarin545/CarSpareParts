package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.GroupPartsEntity;

public interface GroupPartsEntityRepository extends JpaRepository<GroupPartsEntity, Long> {
}
