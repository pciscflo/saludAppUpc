package pe.upc.salud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.upc.salud.entity.HealthCenter;

import java.util.List;

public interface RepositoryHealthCenter extends JpaRepository<HealthCenter,Long> {
    List<HealthCenter> findByType(String type);
}
