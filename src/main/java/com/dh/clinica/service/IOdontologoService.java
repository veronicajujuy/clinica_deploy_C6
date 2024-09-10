package com.dh.clinica.service;

import com.dh.clinica.entity.Odontologo;
import org.apache.coyote.BadRequestException;


import java.util.Optional;

public interface IOdontologoService {
    Odontologo guardarOdontologo(Odontologo odontologo);
    Optional <Odontologo> buscarPorId(Integer id);

    void agregarEspecialidad(Integer id_odontologo, Integer id_especialidad) throws BadRequestException;
}
