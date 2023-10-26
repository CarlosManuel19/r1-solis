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
    @Column(name = "id_cuenta")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCuenta;

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "numero_cuenta")
    private String numeroCuenta;

    @Column(name = "saldo")
    private double saldo;

    @Column(name = "estado")
    private boolean estado;
}
