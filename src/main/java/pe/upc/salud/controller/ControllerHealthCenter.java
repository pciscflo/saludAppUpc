package pe.upc.salud.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.upc.salud.business.BusinessHealthCenter;
import pe.upc.salud.dtos.HealthCenterDTO;
import pe.upc.salud.entity.HealthCenter;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ControllerHealthCenter {
    @Autowired
    private BusinessHealthCenter businessHealthCenter;
    @PostMapping("/healthCenter")
    public ResponseEntity<HealthCenterDTO> register(@RequestBody HealthCenterDTO healthCenterDTO){
        HealthCenter healthCenter = convertToEntity(healthCenterDTO);
        healthCenter = businessHealthCenter.register(healthCenter);
        healthCenterDTO = convertToDto(healthCenter);
        return new ResponseEntity<HealthCenterDTO>(healthCenterDTO, HttpStatus.OK);
    }
    private HealthCenterDTO convertToDto(HealthCenter author) {
        ModelMapper modelMapper = new ModelMapper();
        HealthCenterDTO authorDTO = modelMapper.map(author, HealthCenterDTO.class);
        return authorDTO;
    }

    private HealthCenter convertToEntity(HealthCenterDTO authorDTO) {
        ModelMapper modelMapper = new ModelMapper();
        HealthCenter post = modelMapper.map(authorDTO, HealthCenter.class);
        return post;
    }

    private List<HealthCenterDTO> convertToLisDto(List<HealthCenter> list){
        return list.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}
