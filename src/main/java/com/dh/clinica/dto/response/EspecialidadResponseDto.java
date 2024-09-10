package com.dh.clinica.dto.response;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EspecialidadResponseDto {
    private Integer id;
    private String tipo;
    private Set<OdontologoResponseDto> odontologo;
}
