package com.dmoreno06.retoConversorMoneda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTipo;
    private String monedaOrigen;
    private String monedaDestino;

    @Column(precision = 19, scale = 6)
    private BigDecimal factorConversion;

    public TipoCambio() {
    }

    public TipoCambio(String monedaOrigen, String monedaDestino, BigDecimal FactorConversion) {
        this.monedaOrigen = monedaOrigen;
        this.monedaDestino = monedaDestino;
        this.factorConversion = FactorConversion;
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

    public void setFactorConversion(BigDecimal FactorConversion) {
        this.factorConversion = FactorConversion;
    }

    @Override
    public String toString() {
        return "TipoCambio{" +
                "monedaOrigen='" + monedaOrigen + '\'' +
                ", monedaDestino='" + monedaDestino + '\'' +
                ", montoConversion='" + factorConversion + '\'' +
                '}';
    }
}
