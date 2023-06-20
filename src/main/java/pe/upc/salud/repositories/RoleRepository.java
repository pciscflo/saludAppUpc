package pe.upc.salud.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.upc.salud.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
      Role findRoleByRol(String rol);
}