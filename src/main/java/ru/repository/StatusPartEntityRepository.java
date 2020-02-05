package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.StatusPartEntiry;

public interface StatusPartEntityRepository extends JpaRepository<StatusPartEntiry, Long> {
}
