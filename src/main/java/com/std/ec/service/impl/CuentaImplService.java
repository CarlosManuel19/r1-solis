package com.std.ec.service.impl;


import com.std.ec.model.dao.CuentaDao;
import com.std.ec.model.dto.CuentaDto;
import com.std.ec.model.entity.Cuenta;
import com.std.ec.service.ICuentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CuentaImplService implements ICuentaService {

    @Autowired
    private CuentaDao cuentaDao;

    @Override
    public List<Cuenta> listAlll() {
        return (List) cuentaDao.findAll();
    }

    @Transactional
    @Override
    public Cuenta save(CuentaDto cuentaDto) {
        Cuenta cuenta = Cuenta.builder()
                .idCuenta(cuentaDto.getIdCuenta())
                .nombreCliente(cuentaDto.getNombreCliente())
                .numeroCuenta(cuentaDto.getNumeroCuenta())
                .saldo(cuentaDto.getSaldo())
                .saldo(cuentaDto.getSaldo())
                .build();
        return cuentaDao.save(cuenta);
    }

    @Transactional(readOnly = true)
    @Override
    public Cuenta findById(Integer id) {
        return cuentaDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(Cuenta cuenta) {
        cuentaDao.delete(cuenta);
    }

    @Override
    public boolean existsById(Integer id) {
        return cuentaDao.existsById(id);
    }



}
