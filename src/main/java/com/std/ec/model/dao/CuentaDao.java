package com.std.ec.model.dao;

import com.std.ec.model.entity.Cuenta;
import org.springframework.data.repository.CrudRepository;

public interface CuentaDao extends CrudRepository<Cuenta, Integer> {
}
