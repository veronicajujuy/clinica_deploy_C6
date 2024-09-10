package com.dh.clinica.service.impl;

import com.dh.clinica.dto.response.EspecialidadResponseDto;
import com.dh.clinica.entity.Especialidad;
import com.dh.clinica.repository.IEspecialidadRepository;
import com.dh.clinica.service.IEspecialidadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialidadService implements IEspecialidadService {
    @Autowired
    private IEspecialidadRepository especialidadRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EspecialidadResponseDto guardarEspecialidad(Especialidad especialidad) {
        Especialidad especialidadGuardada = especialidadRepository.save(especialidad);
        return convertirAResponse(especialidadGuardada);
    }

    @Override
    public Optional<EspecialidadResponseDto> buscarPorId(Integer id) {
        Optional<Especialidad> especialidadOptional = especialidadRepository.findById(id);
        return Optional.ofNullable(convertirAResponse(especialidadOptional.get()));
    }

    @Override
    public List<EspecialidadResponseDto> buscarTodos() {
        List<Especialidad> especialidades =especialidadRepository.findAll();
        List<EspecialidadResponseDto> especialidadAResponder = new ArrayList<>();
        for(Especialidad e: especialidades){
            especialidadAResponder.add(convertirAResponse(e));
        }
        return especialidadAResponder;
    }

    EspecialidadResponseDto convertirAResponse(Especialidad especialidad){
        modelMapper.typeMap(Especialidad.class, EspecialidadResponseDto.class).addMappings(
                mapper -> mapper.map(src -> src.getOdontologos(), EspecialidadResponseDto::setOdontologo)
        );
        return modelMapper.map(especialidad, EspecialidadResponseDto.class);
    }
}
