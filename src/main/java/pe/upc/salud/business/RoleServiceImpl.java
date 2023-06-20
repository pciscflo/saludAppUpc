package pe.upc.salud.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.upc.salud.entity.Role;
import pe.upc.salud.repositories.RoleRepository;

import java.util.List;


@Service
public class RoleServiceImpl {
	@Autowired
	private RoleRepository rR;
	@Transactional
	public Integer insertRol(Role role){
		if(rR.findRoleByRol(role.getRol())==null){
			rR.save(role);
			return 1;
		}
		return 0;
	}
	public List<Role> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}
