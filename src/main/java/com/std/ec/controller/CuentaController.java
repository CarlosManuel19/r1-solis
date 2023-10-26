package com.std.ec.controller;

import com.std.ec.model.dto.CuentaDto;
import com.std.ec.model.entity.Cuenta;
import com.std.ec.model.payload.MensajeResponse;
import com.std.ec.service.ICuentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CuentaController {

    @Autowired
    private ICuentaService cuentaService;

    @GetMapping("accounts")
    public ResponseEntity<?> showAll() {
        List<Cuenta> getList = cuentaService.listAlll();
        if (getList == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje("No hay registros")
                            .object(null)
                            .build()
                    , HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mnesaje("")
                        .object(getList)
                        .build()
                , HttpStatus.OK);
    }


    @PostMapping("accounts")
    public ResponseEntity<?> create(@RequestBody CuentaDto cuentaDto) {
        Cuenta cuentaSave = null;
        try {
            cuentaSave = cuentaService.save(cuentaDto);
            return new ResponseEntity<>(MensajeResponse.builder()
                    .mnesaje("Guardado correctamente")
                    .object(CuentaDto.builder()
                            .idCuenta(cuentaSave.getIdCuenta())
                            .nombreCliente(cuentaSave.getNombreCliente())
                            .numeroCuenta(cuentaSave.getNumeroCuenta())
                            .saldo(cuentaSave.getSaldo())
                            .estado(cuentaSave.isEstado())
                            .build())
                    .build()
                    , HttpStatus.CREATED);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @PutMapping("accounts/{id}")
    public ResponseEntity<?> update(@RequestBody CuentaDto cuentaDto, @PathVariable Integer id) {
        Cuenta cuentaUpdate = null;
        try {
            if (cuentaService.existsById(id)) {
                cuentaDto.setIdCuenta(id);
                cuentaUpdate = cuentaService.save(cuentaDto);
                return new ResponseEntity<>(MensajeResponse.builder()
                        .mnesaje("Guardado correctamente")
                        .object(CuentaDto.builder()
                                .idCuenta(cuentaDto.getIdCuenta())
                                .nombreCliente(cuentaDto.getNombreCliente())
                                .numeroCuenta(cuentaDto.getNumeroCuenta())
                                .saldo(cuentaDto.getSaldo())
                                .estado(cuentaDto.isEstado())
                                .build())
                        .build()
                        , HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MensajeResponse.builder()
                                .mnesaje("El registro que intenta actualizar no se encuentra en la base de datos.")
                                .object(null)
                                .build()
                        , HttpStatus.NOT_FOUND);
            }
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    @DeleteMapping("accounts/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            Cuenta cuentaDelete = cuentaService.findById(id);
            cuentaService.delete(cuentaDelete);
            return new ResponseEntity<>(cuentaDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDt) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje(exDt.getMessage())
                            .object(null)
                            .build()
                    , HttpStatus.METHOD_NOT_ALLOWED);
        }
    }


    @GetMapping("accounts/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
       Cuenta cuenta = cuentaService.findById(id);

        if (cuenta == null) {
            return new ResponseEntity<>(
                    MensajeResponse.builder()
                            .mnesaje("El registro que intenta buscar, no existe!!")
                            .object(null)
                            .build()
                    , HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MensajeResponse.builder()
                        .mnesaje("")
                        .object(CuentaDto.builder()
                                .idCuenta(cuenta.getIdCuenta())
                                .nombreCliente(cuenta.getNombreCliente())
                                .numeroCuenta(cuenta.getNumeroCuenta())
                                .saldo(cuenta.getSaldo())
                                .estado(cuenta.isEstado())
                                .build())
                        .build()
                , HttpStatus.OK);
    }

}
