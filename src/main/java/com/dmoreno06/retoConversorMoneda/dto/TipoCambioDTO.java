package com.dmoreno06.retoConversorMoneda.dto;


public class TipoCambioDTO {
    private String monedaOrigen;
    private String monedaDestino;
    private double factorConversion;

    public TipoCambioDTO(){

    }

    public TipoCambioDTO(String monedaOrigen, String monedaDestino, double montoConversion) {
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

    public Double getMontoConversion() {
        return factorConversion;
    }

    public void setMontoConversion(double montoConversion) {
        this.factorConversion = montoConversion;
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
