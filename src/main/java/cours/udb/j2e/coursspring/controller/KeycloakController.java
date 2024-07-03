package cours.udb.j2e.coursspring.controller;

import cours.udb.j2e.coursspring.dto.UserDTO;
import cours.udb.j2e.coursspring.service.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/keycloak/users")
public class KeycloakController {

    private final KeycloakService keycloakService;

    public KeycloakController(KeycloakService keycloakService) {
        this.keycloakService = keycloakService;
    }

    @GetMapping
    public List<UserRepresentation> getUsers() {

        return keycloakService.getUsers();
    }

    @GetMapping("/{username}")
    public UserRepresentation getUser(@PathVariable String username) {

        return keycloakService.getUser(username);
    }

    @PostMapping
    public UserRepresentation createUser(@RequestBody UserDTO userDTO) {

        keycloakService.createUser(userDTO);
        return keycloakService.getUser(userDTO.getUserName());
    }

    @PutMapping("change-password")
    public void updatePassword(Principal principal) {
        keycloakService.updatePassword(principal.getName());
    }

}
