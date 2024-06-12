package cours.udb.j2e.coursspring.controller;

import cours.udb.j2e.coursspring.service.KeycloakService;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}
