package pe.upc.salud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import pe.upc.salud.business.RoleServiceImpl;
import pe.upc.salud.business.UserServiceImpl;
import pe.upc.salud.entity.Role;

import java.util.List;


@Controller
@SessionAttributes
@RequestMapping("/roles")
public class RoleController {

	@Autowired
	private UserServiceImpl uService;
	@Autowired
	private RoleServiceImpl rService;

	@PostMapping("/save")
	public ResponseEntity<Integer> newRole(@RequestBody Role role) {
		Integer rpta;
		rpta = rService.insertRol(role);
		return new ResponseEntity<Integer>(1, HttpStatus.OK);
	}

	@GetMapping("/list")
	public List<Role> listRole(Model model) {
		return rService.list();
	}

}
