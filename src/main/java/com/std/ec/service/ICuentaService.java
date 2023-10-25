package com.std.ec.service;

import com.std.ec.model.dto.CuentaDto;
import com.std.ec.model.entity.Cuenta;

import java.util.List;

public interface ICuentaService {

    List<Cuenta> listAlll();

    Cuenta save(CuentaDto cuentaDto);

    Cuenta findById(Integer id);

    void delete(Cuenta cuenta);

    boolean existsById(Integer id);

}
