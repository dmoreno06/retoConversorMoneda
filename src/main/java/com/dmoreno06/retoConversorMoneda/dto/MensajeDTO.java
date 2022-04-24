package com.dmoreno06.retoConversorMoneda.dto;

public class MensajeDTO {
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public MensajeDTO(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return "mensajeDTO{" +
                "mensaje='" + mensaje + '\'' +
                '}';
    }
}
