package com.std.ec.model.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "cuentas") // Cambia el nombre de la tabla a "cuentas"
public class Cuenta implements Serializable {

    @Id
    @Column(name = "id_cuenta") // Cambia el nombre de la columna a "id_cuenta"
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta; // Cambia el nombre del atributo

    @Column(name = "nombre_cliente") // Nuevo atributo para el nombre del cliente
    private String nombreCliente;

    @Column(name = "numero_cuenta") // Nuevo atributo para el número de cuenta
    private String numeroCuenta;

    @Column(name = "saldo") // Nuevo atributo para el saldo de la cuenta
    private double saldo;

    @Column(name = "estado") // Nuevo atributo para el estado de la cuenta
    private boolean estado;
}
