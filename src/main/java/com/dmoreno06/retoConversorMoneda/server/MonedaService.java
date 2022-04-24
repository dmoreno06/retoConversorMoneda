package com.dmoreno06.retoConversorMoneda.server;

import com.dmoreno06.retoConversorMoneda.entity.Moneda;
import com.dmoreno06.retoConversorMoneda.repository.MonedaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class  MonedaService {
    @Autowired
    MonedaRepository monedaRepository;


    public List<Moneda> list() {
        return monedaRepository.findAll();
    }
    public Optional<Moneda> getOne(int id){
        return monedaRepository.findById(id);
    }
    public Optional<Moneda> getOneCo(String codigo){
        return monedaRepository.findByCodigo(codigo);
    }
    public void save(Moneda moneda){
        monedaRepository.save(moneda);
    }
    public void delete(int id){
        monedaRepository.deleteById(id);
    }
    public boolean existsById(int id){
        return monedaRepository.existsById(id);
    }
    public boolean existsByCodigo(String codigo){
        return monedaRepository.existsByCodigo(codigo);
    }

}
