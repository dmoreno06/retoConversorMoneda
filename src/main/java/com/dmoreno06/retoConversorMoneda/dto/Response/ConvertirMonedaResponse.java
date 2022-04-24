package com.dmoreno06.retoConversorMoneda.dto.Response;

import com.dmoreno06.retoConversorMoneda.dto.TrazabilidadDTO;

import java.math.BigDecimal;

public class ConvertirMonedaResponse{

    private String monedaDestino;
    private BigDecimal montoConvertido;

    public ConvertirMonedaResponse() {
        super();
    }

    public ConvertirMonedaResponse(String monedaDestino, BigDecimal montoConvertido) {
        this.monedaDestino = monedaDestino;
        this.montoConvertido = montoConvertido;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public BigDecimal getMontoConvertido() {
        return montoConvertido;
    }

    public void setMontoConvertido(BigDecimal montoConvertido) {
        this.montoConvertido = montoConvertido;
    }
}
