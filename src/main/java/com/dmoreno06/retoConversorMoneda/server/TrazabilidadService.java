package com.dmoreno06.retoConversorMoneda.server;

import com.dmoreno06.retoConversorMoneda.entity.Trazabilidad;
import com.dmoreno06.retoConversorMoneda.repository.TrazabilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TrazabilidadService {
    @Autowired
    TrazabilidadRepository trazabilidadRepository;

    public List<Trazabilidad> list() {
        return trazabilidadRepository.findAll();
    }
    public void save(Trazabilidad trazabilidad){
        trazabilidadRepository.save(trazabilidad);
    }
    public List<Trazabilidad> listTipoCambio() {
        return trazabilidadRepository.findAll();
    }
    public void update(Trazabilidad trazabilidad){
        trazabilidadRepository.save(trazabilidad);
    }
}
