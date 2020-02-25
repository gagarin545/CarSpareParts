package ru.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.entity.EditReference;

public interface EditRepository extends JpaRepository<EditReference, Long> {
}
