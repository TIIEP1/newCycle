package com.NewCycle.cashtrash.repositories;

import com.NewCycle.cashtrash.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
