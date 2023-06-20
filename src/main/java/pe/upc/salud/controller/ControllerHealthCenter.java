package pe.upc.salud.controller;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
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
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<HealthCenterDTO> register(@RequestBody HealthCenterDTO healthCenterDTO){
        HealthCenter healthCenter = convertToEntity(healthCenterDTO);
        healthCenter = businessHealthCenter.register(healthCenter);
        healthCenterDTO = convertToDto(healthCenter);
        return new ResponseEntity<HealthCenterDTO>(healthCenterDTO, HttpStatus.OK);
    }
    @GetMapping("/centers")
    public ResponseEntity<List<HealthCenterDTO>> listHealthCenters() throws Exception {
        List<HealthCenterDTO> healthCenters = null;
        try {
            healthCenters = businessHealthCenter.listHealthCenterCalification();
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception("No es posible obtenerlo");
        }
        return new ResponseEntity<List<HealthCenterDTO>>(healthCenters, HttpStatus.OK);
    }
    @GetMapping("/centerspointsinfra/{points}")
    public List<HealthCenterDTO> listHealthCentersPointInfraestructure(
                                 @PathVariable(name = "points") Integer points){
        List<HealthCenterDTO> healthCenters = null;
        healthCenters = convertToLisDto(businessHealthCenter.listHealthCenterByPoitsInfraestructure(points));
        return  healthCenters;
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
