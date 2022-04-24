package com.dmoreno06.retoConversorMoneda.repository;

import com.dmoreno06.retoConversorMoneda.entity.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MonedaRepository extends JpaRepository<Moneda, Integer> {
    Optional<Moneda> findByCodigo(String codigo);
    boolean existsByCodigo(String codigo);
}