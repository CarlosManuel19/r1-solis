package com.std.ec.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@ToString
@Builder
public class CuentaDto implements Serializable {

    private Integer idCuenta; // Cambia el nombre del atributo

    private String nombreCliente;

    private String numeroCuenta;

    private double saldo;

    private boolean estado;

}
