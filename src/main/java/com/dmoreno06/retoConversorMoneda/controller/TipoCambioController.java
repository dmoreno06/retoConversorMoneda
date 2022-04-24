package com.dmoreno06.retoConversorMoneda.controller;


import com.dmoreno06.retoConversorMoneda.dto.MensajeDTO;
import com.dmoreno06.retoConversorMoneda.dto.Request.ConvertirMonedaRequest;
import com.dmoreno06.retoConversorMoneda.dto.Request.CrearTipoCambioRequest;
import com.dmoreno06.retoConversorMoneda.dto.Response.ConvertirMonedaResponse;
import com.dmoreno06.retoConversorMoneda.entity.TipoCambio;
import com.dmoreno06.retoConversorMoneda.entity.Trazabilidad;
import com.dmoreno06.retoConversorMoneda.server.TipoCambioService;
import com.dmoreno06.retoConversorMoneda.server.TrazabilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

@RestController
@RequestMapping("/tipoCambio")
@CrossOrigin(origins = "http://localhost:4200")
public class TipoCambioController {
    @Autowired
    TipoCambioService tipoCambioService;

    @Autowired
    TrazabilidadService trazabilidadService;

    @GetMapping("/list")
    public ResponseEntity<List<TipoCambio>> list(){
        List<TipoCambio> list = tipoCambioService.list();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody CrearTipoCambioRequest crearTipoCambioRequest){
        if(crearTipoCambioRequest.getMonedaDestino().equals(null))
            return new ResponseEntity(new MensajeDTO("la moneda destino es obligatorio"), HttpStatus.BAD_REQUEST);
        if(crearTipoCambioRequest.getFactorConversion().equals(0) )
            return new ResponseEntity(new MensajeDTO("el valor debe ser mayor que 0"), HttpStatus.BAD_REQUEST);
        if(tipoCambioService.existsByMonedaAndMonedaOrigenaAndAndMonedaDestino(crearTipoCambioRequest.getMonedaOrigen(),
                crearTipoCambioRequest.getMonedaDestino()))
            return new ResponseEntity(new MensajeDTO("ese codigo ya existe"), HttpStatus.BAD_REQUEST);
        //DecimalFormat df = new DecimalFormat("#.0000");
//        BigDecimal valorF= new BigDecimal(format(crearTipoCambioRequest.getFactorConversion());
//
        TipoCambio tipoCambio = new TipoCambio(crearTipoCambioRequest.getMonedaOrigen(),
                crearTipoCambioRequest.getMonedaDestino(),crearTipoCambioRequest.getFactorConversion());
        Trazabilidad trazabilidad = new Trazabilidad(crearTipoCambioRequest.getTipoModificacion(),
                crearTipoCambioRequest.getNombreUsuario(),crearTipoCambioRequest.getFechaRegistro());

        tipoCambioService.save(tipoCambio);
        trazabilidadService.save(trazabilidad);
        return new ResponseEntity(new MensajeDTO("producto creado"), HttpStatus.OK);
    }


    @PostMapping("/convertirMoneda")
    public ResponseEntity<ConvertirMonedaResponse> converir(@RequestBody ConvertirMonedaRequest convertirMonedaRequest){
        ConvertirMonedaResponse convertirMonedaResponse = tipoCambioService.convertirMoneda(
                convertirMonedaRequest.getMonedaOrigen(),convertirMonedaRequest.getMonedaDestino(),
                convertirMonedaRequest.getMonaConvertir());
        return new ResponseEntity<>(convertirMonedaResponse, HttpStatus.OK);
    }





}
