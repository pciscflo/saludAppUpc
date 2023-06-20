package pe.upc.salud.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import pe.upc.salud.business.UserServiceImpl;
import pe.upc.salud.entity.User;

@Controller
@Secured({"ROLE_ADMIN"})
@RequestMapping("/users")
public class UserController {
	@Autowired
	private PasswordEncoder bcrypt;
	@Autowired
	private UserServiceImpl uService;

	@PostMapping("/save")
	public ResponseEntity<Integer> saveUser(@RequestBody User user) {
		if (uService.buscarUser(user.getUsername()) == 0) {
			String bcryptPassword = bcrypt.encode(user.getPassword());
			user.setPassword(bcryptPassword);
			uService.insertUser(user);
			return new ResponseEntity<Integer>(1, HttpStatus.OK);
		}
		return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
	}
	@PostMapping("/save/{user_id}/{rol_id}")
	public ResponseEntity<Integer> saveUseRol(@PathVariable("user_id") Long user_id,
											  @PathVariable("rol_id") Long rol_id){
		   //return new ResponseEntity<Integer>(uService.insertUserRol(user_id, rol_id),HttpStatus.OK);
		return new ResponseEntity<Integer>(uService.insertUserRol2(user_id, rol_id),HttpStatus.OK);
	}

}

