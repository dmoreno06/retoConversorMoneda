package com.dmoreno06.retoConversorMoneda.controller;

import com.dmoreno06.retoConversorMoneda.dto.MensajeDTO;
import com.dmoreno06.retoConversorMoneda.dto.MonedaDTO;
import com.dmoreno06.retoConversorMoneda.entity.Moneda;
import com.dmoreno06.retoConversorMoneda.server.MonedaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/moneda")
@CrossOrigin(origins = "http://localhost:4200")
public class MonedaController {
    @Autowired
    MonedaService monedaService;

    @GetMapping("/lista")
    public ResponseEntity<List<Moneda>> list(){
        List<Moneda> list = monedaService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/detalle/{codigo}")
    public ResponseEntity<List<Moneda>> getByCodigo(@PathVariable("codigo") String codigo){
        if (!monedaService.existsByCodigo(codigo))
            return new ResponseEntity(new MensajeDTO("no existe"), HttpStatus.NOT_FOUND);
        Moneda moneda = monedaService.getOneCo(codigo).get();
        return new ResponseEntity(moneda, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<?> create(@RequestBody MonedaDTO monedaDTO){
        if(monedaDTO.getCodigo()==null)
            return new ResponseEntity(new MensajeDTO("el codigo es obligatorio"), HttpStatus.BAD_REQUEST);
        if(monedaDTO.getValor()< 0 )
            return new ResponseEntity(new MensajeDTO("el valor debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(monedaService.existsByCodigo(monedaDTO.getCodigo()))
            return new ResponseEntity(new MensajeDTO("ese codigo ya existe"), HttpStatus.BAD_REQUEST);
        Moneda moneda = new Moneda(monedaDTO.getCodigo(), monedaDTO.getDescripcion(),monedaDTO.getValor());
        monedaService.save(moneda);
        return new ResponseEntity(new MensajeDTO("moneda creada"), HttpStatus.OK);
    }


    @PutMapping("/editar/{id}")
    public ResponseEntity<?> update(@PathVariable("id")int id, @RequestBody MonedaDTO monedaDTO){
        if(!monedaService.existsById(id))
            return new ResponseEntity(new MensajeDTO("no existe"), HttpStatus.NOT_FOUND);
        if(monedaService.existsByCodigo(monedaDTO.getCodigo()))
            return new ResponseEntity(new MensajeDTO("ese el codigo ya existe"), HttpStatus.BAD_REQUEST);
        if(monedaDTO.getCodigo().equals(null))
            return new ResponseEntity(new MensajeDTO("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        if(monedaDTO.getCodigo()==null )
            return new ResponseEntity(new MensajeDTO("el valor debe ser mayor que 0"), HttpStatus.BAD_REQUEST);

        Moneda moneda = monedaService.getOne((id)).get();
        moneda.setCodigo(monedaDTO.getCodigo());
        moneda.setDescripcion(monedaDTO.getDescripcion());
        monedaService.save(moneda);
        return new ResponseEntity(new MensajeDTO("producto actualizado"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable("id")int id){
        if(!monedaService.existsById(id))
            return new ResponseEntity(new MensajeDTO("no existe"), HttpStatus.NOT_FOUND);
        monedaService.delete(id);
        return new ResponseEntity(new MensajeDTO("producto eliminado"), HttpStatus.OK);
    }
}
