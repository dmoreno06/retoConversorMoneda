package com.dmoreno06.retoConversorMoneda.dto;

import java.util.Objects;

public class TrazabilidadDTO {
    private String tipoModificacion;
    private String nombreUsuario;
    private String fechaRegistro;

    public TrazabilidadDTO() {
    }
    public TrazabilidadDTO(String tipoModificacion, String nombreUsuario, String rechaRegistro) {
        this.tipoModificacion = tipoModificacion;
        this.nombreUsuario = nombreUsuario;
        this.fechaRegistro = fechaRegistro;
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
    public String toString() {
        return "TrazabilidadDTO{" +
                "tipoModificacion='" + tipoModificacion + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", rechaRegistro='" + fechaRegistro + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrazabilidadDTO)) return false;
        TrazabilidadDTO that = (TrazabilidadDTO) o;
        return Objects.equals(getTipoModificacion(), that.getTipoModificacion()) && Objects.equals(getNombreUsuario(), that.getNombreUsuario()) && Objects.equals(getFechaRegistro(), that.getFechaRegistro());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTipoModificacion(), getNombreUsuario(), getFechaRegistro());
    }
}
