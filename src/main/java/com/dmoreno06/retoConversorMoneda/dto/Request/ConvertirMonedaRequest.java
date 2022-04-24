package com.dmoreno06.retoConversorMoneda.dto.Request;

import com.dmoreno06.retoConversorMoneda.dto.TrazabilidadDTO;

import java.math.BigDecimal;
import java.util.Objects;

public class ConvertirMonedaRequest extends TrazabilidadDTO {

    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal montoaConvertir;

    public ConvertirMonedaRequest() {
        super();
    }

    public ConvertirMonedaRequest(String tipoModificacion, String nombreUsuario, String fechaRegistro,
                                  String monedaOrigen, String monedaDestino, BigDecimal montoConversion) {
        super(tipoModificacion, nombreUsuario, fechaRegistro);
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.montoaConvertir = montoConversion;
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

    public BigDecimal getMonaConvertir() {
        return montoaConvertir;
    }

    public void setMontoaConvertir(BigDecimal montoConversion) {
        this.montoaConvertir = montoConversion;
    }

    @Override
    public String toString() {
        return "ListarTipoCambioRequest{" +
                "monedaOrigen=" + monedaOrigen +
                ", monedaDestino=" + monedaDestino +
                ", montoConversion=" + montoaConvertir +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ConvertirMonedaRequest)) return false;
        if (!super.equals(o)) return false;
        ConvertirMonedaRequest that = (ConvertirMonedaRequest) o;
        return Objects.equals(getMonedaOrigen(), that.getMonedaOrigen()) && Objects.equals(getMonedaDestino(), that.getMonedaDestino()) && Objects.equals(montoaConvertir, that.montoaConvertir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMonedaOrigen(), getMonedaDestino(), montoaConvertir);
    }
}
