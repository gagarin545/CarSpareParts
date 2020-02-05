package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.ClientEntity;

public interface ClientEntityRepository extends JpaRepository <ClientEntity, Long> {
}
