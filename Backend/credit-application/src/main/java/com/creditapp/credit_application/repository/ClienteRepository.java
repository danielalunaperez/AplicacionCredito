package com.creditapp.credit_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creditapp.credit_application.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}

