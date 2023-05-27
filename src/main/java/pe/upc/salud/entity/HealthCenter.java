package pe.upc.salud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HealthCenter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private Integer pointsInfraeatructure;
    private Integer pointsServices;
    private boolean ambulances;

    private transient double calification;

    public HealthCenter() {
    }

    public HealthCenter(Long id, String name, String type, Integer pointsInfraeatructure, Integer pointsServices, boolean ambulances) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.pointsInfraeatructure = pointsInfraeatructure;
        this.pointsServices = pointsServices;
        this.ambulances = ambulances;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getPointsInfraeatructure() {
        return pointsInfraeatructure;
    }

    public void setPointsInfraeatructure(Integer pointsInfraeatructure) {
        this.pointsInfraeatructure = pointsInfraeatructure;
    }

    public Integer getPointsServices() {
        return pointsServices;
    }

    public void setPointsServices(Integer pointsServices) {
        this.pointsServices = pointsServices;
    }

    public boolean isAmbulances() {
        return ambulances;
    }

    public void setAmbulances(boolean ambulances) {
        this.ambulances = ambulances;
    }

    @Override
    public String toString() {
        return "HealthCenter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", pointsInfraeatructure=" + pointsInfraeatructure +
                ", pointsServices=" + pointsServices +
                ", ambulances=" + ambulances +
                '}';
    }
}
