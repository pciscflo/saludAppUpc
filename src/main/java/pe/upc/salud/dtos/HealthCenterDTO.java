package pe.upc.salud.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class HealthCenterDTO {
    private Long id;
    private String name;
    private String type;
    private Integer pointsInfraeatructure;
    private Integer pointsServices;
    private boolean ambulances;
    private Double calification;

}
