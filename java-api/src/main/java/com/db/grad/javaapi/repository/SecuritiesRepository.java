package com.db.grad.javaapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.db.grad.javaapi.model.Security;

public interface SecuritiesRepository extends JpaRepository<Security, Integer> {
    // Intentionally blank
}
