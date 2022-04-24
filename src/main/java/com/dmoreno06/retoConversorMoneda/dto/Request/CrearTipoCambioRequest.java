package com.dmoreno06.retoConversorMoneda.dto.Request;

import com.dmoreno06.retoConversorMoneda.dto.TrazabilidadDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class CrearTipoCambioRequest extends TrazabilidadDTO {

    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal factorConversion;

    public CrearTipoCambioRequest() {
        super();
    }
    
    public CrearTipoCambioRequest(String tipoModificacion, String nombreUsuario, String fechaRegistro,
                                  String monedaOrigen, String monedaDestino, BigDecimal montoConversion) {
        super(tipoModificacion, nombreUsuario, fechaRegistro);
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.factorConversion = montoConversion;
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public BigDecimal getFactorConversion() {
        return factorConversion;
    }

    public void setFactorConversion(BigDecimal montoConversion) {
        this.factorConversion = montoConversion;
    }

    @Override
    public String toString() {
        return "ListarTipoCambioRequest{" +
                "monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", factorConversion=" + factorConversion +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrearTipoCambioRequest)) return false;
        if (!super.equals(o)) return false;
        CrearTipoCambioRequest that = (CrearTipoCambioRequest) o;
        return Objects.equals(getMonedaOrigen(), that.getMonedaOrigen()) && Objects.equals(getMonedaDestino(), that.getMonedaDestino()) && Objects.equals(factorConversion, that.factorConversion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonedaOrigen(), getMonedaDestino(), factorConversion);
    }
}
