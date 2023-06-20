package pe.upc.salud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.upc.salud.dtos.HealthCenterDTO;
import pe.upc.salud.entity.HealthCenter;

import java.util.List;

public interface RepositoryHealthCenter extends JpaRepository<HealthCenter,Long> {
    List<HealthCenter> findByType(String type);
    List<HealthCenter> findHealthCentersByPointsInfraeatructureAfter(Integer points);
    @Query("select max(t.pointsServices) from HealthCenter t")
    Integer findHealthCentersMaxService();
    List<HealthCenter> findAllByAmbulancesIsTrueOrderByName();
    @Query("select new pe.upc.salud.dtos.HealthCenterDTO(h.id, h.name, h.type, h.pointsInfraeatructure," +
            " h.pointsServices, h.ambulances, h.pointsInfraeatructure*0.35 + h.pointsServices*0.65) from HealthCenter h")
    List<HealthCenterDTO> findAllDTOs();

}
