package pe.upc.salud.dtos;

import pe.upc.salud.entity.Role;

import java.util.List;

public class UserDTO {
    private Long id;

    private String username;

    private String password;
    private Boolean enabled;

    private List<Role> roles;
}
