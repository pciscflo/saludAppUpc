package pe.upc.salud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class HealthCenterDTO {
    private Long id;
    private String name;
    private String type;
    private Integer pointsInfraeatructure;
    private Integer pointsServices;
    private boolean ambulances;
    private double calification;

    public HealthCenterDTO(Long id, String name, String type, Integer pointsInfraeatructure, Integer pointsServices, boolean ambulances, double calification) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pointsInfraeatructure = pointsInfraeatructure;
        this.pointsServices = pointsServices;
        this.ambulances = ambulances;
        this.calification = calification;
    }
}
