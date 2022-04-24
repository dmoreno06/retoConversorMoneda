package com.dmoreno06.retoConversorMoneda.repository;

import com.dmoreno06.retoConversorMoneda.entity.TipoCambio;
import com.dmoreno06.retoConversorMoneda.entity.Trazabilidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TrazabilidadRepository extends JpaRepository<Trazabilidad, Integer> {
    Optional<Trazabilidad> findByTipoModificacion(String tipoModificacion);
}