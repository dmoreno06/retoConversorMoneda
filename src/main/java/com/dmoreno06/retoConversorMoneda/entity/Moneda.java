package com.dmoreno06.retoConversorMoneda.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Moneda {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMoneda;
    private String codigo;
    private String descripcion;

    public Moneda() {
    }
    public Moneda(String codigo, double valor) {
    }


    public Moneda(String codigo, String descripcion, double valor) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public Integer getIdMoneda() {
        return idMoneda;
    }

    public void setIdMoneda(Integer idMoneda) {
        this.idMoneda = idMoneda;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }



    @Override
    public String toString() {
        return "Moneda{" +
                "idMoneda=" + idMoneda +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Moneda)) return false;
        Moneda moneda = (Moneda) o;
        return Objects.equals(getIdMoneda(), moneda.getIdMoneda()) && Objects.equals(getCodigo(), moneda.getCodigo())
                && Objects.equals(getDescripcion(), moneda.getDescripcion());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdMoneda(), getCodigo(), getDescripcion());
    }
}
