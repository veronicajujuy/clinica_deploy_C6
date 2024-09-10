package com.dh.clinica.service.impl;

import com.dh.clinica.entity.Especialidad;
import com.dh.clinica.entity.Odontologo;
import com.dh.clinica.exception.BadRequestNewException;
import com.dh.clinica.repository.IEspecialidadRepository;
import com.dh.clinica.repository.IOdontologoRepository;
import com.dh.clinica.service.IOdontologoService;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OdontologoService implements IOdontologoService {

    private IOdontologoRepository iOdontologoRepository;
    private IEspecialidadRepository especialidadRepository;

    public OdontologoService(IOdontologoRepository iOdontologoRepository, IEspecialidadRepository especialidadRepository) {
        this.iOdontologoRepository = iOdontologoRepository;
        this.especialidadRepository = especialidadRepository;
    }

    @Override
    public Odontologo guardarOdontologo(Odontologo odontologo) {
        return iOdontologoRepository.save(odontologo);
    }

    @Override
    public Optional<Odontologo> buscarPorId(Integer id) {
        return iOdontologoRepository.findById(id);
    }

    @Override
    public void agregarEspecialidad(Integer id_odontologo, Integer id_especialidad) {
        Optional<Odontologo> odontologoEncontrado = iOdontologoRepository.findById(id_odontologo);
        Optional<Especialidad> especialidadEncontrada = especialidadRepository.findById(id_especialidad);
        Odontologo odontologo;
        if(odontologoEncontrado.isPresent() && especialidadEncontrada.isPresent()){
            odontologo = odontologoEncontrado.get();
            odontologo.getEspecialidades().add(especialidadEncontrada.get());
            iOdontologoRepository.save(odontologo);
        } else {
            throw new BadRequestNewException("Odontologo o especialidad no encontrados");
        }
    }
}
