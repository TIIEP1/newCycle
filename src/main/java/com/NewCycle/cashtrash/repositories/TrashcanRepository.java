package com.NewCycle.cashtrash.repositories;

import com.NewCycle.cashtrash.model.Trashcan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrashcanRepository extends JpaRepository<Trashcan, Long> {
}
