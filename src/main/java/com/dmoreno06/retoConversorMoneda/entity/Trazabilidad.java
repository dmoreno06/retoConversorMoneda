package com.dmoreno06.retoConversorMoneda.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Trazabilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTraza;
    private String tipoModificacion;
    private String nombreUsuario;
    private String fechaRegistro;

    public Trazabilidad() {
    }

    public Trazabilidad(String tipoModificacion, String nombreUsuario, String fechaRegistro) {
        this.tipoModificacion = tipoModificacion;
        this.nombreUsuario = nombreUsuario;
        this.fechaRegistro = fechaRegistro;
    }

    public Integer getIdTraza() {
        return idTraza;
    }

    public void setIdTraza(Integer idTraza) {
        this.idTraza = idTraza;
    }

    public String getTipoModificacion() {
        return tipoModificacion;
    }

    public void setTipoModificacion(String tipoModificacion) {
        this.tipoModificacion = tipoModificacion;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trazabilidad)) return false;
        Trazabilidad that = (Trazabilidad) o;
        return Objects.equals(getIdTraza(), that.getIdTraza()) && Objects.equals(getTipoModificacion(),
                that.getTipoModificacion()) && Objects.equals(getNombreUsuario(), that.getNombreUsuario()) && Objects.equals(getFechaRegistro(), that.getFechaRegistro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdTraza(), getTipoModificacion(), getNombreUsuario(), getFechaRegistro());
    }

    @Override
    public String toString() {
        return "Trazabilidad{" +
                "idTraza=" + idTraza +
                ", tipoModificacion='" + tipoModificacion + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", fechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }
}
