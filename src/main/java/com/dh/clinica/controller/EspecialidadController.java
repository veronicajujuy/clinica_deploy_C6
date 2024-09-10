package com.dh.clinica.controller;

import com.dh.clinica.dto.response.EspecialidadResponseDto;
import com.dh.clinica.entity.Especialidad;
import com.dh.clinica.service.IEspecialidadService;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/especialidad")
public class EspecialidadController {
    private IEspecialidadService especialidadService;

    public EspecialidadController(IEspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    @PostMapping("/guardar")
    ResponseEntity<EspecialidadResponseDto> guardar (@RequestBody Especialidad especialidad){
        return ResponseEntity.ok(especialidadService.guardarEspecialidad(especialidad));
    }

    @GetMapping("/buscartodos")
    ResponseEntity<List<EspecialidadResponseDto>> buscarTodos (){
        return ResponseEntity.ok(especialidadService.buscarTodos());
    }
}
