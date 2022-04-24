package com.dmoreno06.retoConversorMoneda.server;

import com.dmoreno06.retoConversorMoneda.dto.Response.ConvertirMonedaResponse;
import com.dmoreno06.retoConversorMoneda.entity.TipoCambio;
import com.dmoreno06.retoConversorMoneda.repository.TipoCambioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TipoCambioService {
    @Autowired
    TipoCambioRepository tipoCambioRepository;

    public List<TipoCambio> list() {

        return tipoCambioRepository.findAll();
    }
    public void save(TipoCambio tipoCambio){
        tipoCambioRepository.save(tipoCambio);
    }
    public boolean existsByMonedaAndMonedaOrigenaAndAndMonedaDestino(String monedaOrigen, String monedaDestino){
        return tipoCambioRepository.existsByMonedaOrigenAndMonedaDestino(monedaOrigen,monedaDestino);
    }

    public ConvertirMonedaResponse convertirMoneda(String monedaOrigen, String monedaDestino, BigDecimal montoaConvertir) {
        TipoCambio tipoCambio = tipoCambioRepository.findByMonedaOrigenAndMonedaDestino(monedaOrigen,monedaDestino);
                ConvertirMonedaResponse convertirTipoCambioResponse = new ConvertirMonedaResponse();
        convertirTipoCambioResponse.setMontoConvertido(tipoCambio.getFactorConversion().multiply(montoaConvertir));
        convertirTipoCambioResponse.setMonedaDestino(tipoCambio.getMonedaDestino());
        return convertirTipoCambioResponse;
    }

}
