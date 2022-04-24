package com.dmoreno06.retoConversorMoneda.repository;

import com.dmoreno06.retoConversorMoneda.entity.Moneda;
import com.dmoreno06.retoConversorMoneda.entity.TipoCambio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoCambioRepository extends JpaRepository<TipoCambio, Integer> {
    boolean existsByMonedaOrigenAndMonedaDestino( String monedaOrigen, String monedaDestino);
    TipoCambio findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}