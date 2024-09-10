package com.dh.clinica.service;

import com.dh.clinica.dto.response.EspecialidadResponseDto;
import com.dh.clinica.entity.Especialidad;
import com.dh.clinica.entity.Paciente;

import java.util.List;
import java.util.Optional;

public interface IEspecialidadService {
    EspecialidadResponseDto guardarEspecialidad(Especialidad especialidad);

    Optional<EspecialidadResponseDto> buscarPorId(Integer id);

    List<EspecialidadResponseDto> buscarTodos();
}
