package cours.udb.j2e.coursspring.service;

import cours.udb.j2e.coursspring.dto.UserDTO;
import cours.udb.j2e.coursspring.exception.ScolariteException;
import cours.udb.j2e.coursspring.keycloak.Credentials;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.resource.RealmResource;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.idm.ClientRepresentation;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Component
public class KeycloakService {

    @Value("${app.keycloak.realm.name}")
    private String realm;

    @Value("${app.keycloak.client-id}")
    private String clientId;

    @Autowired
    Keycloak keycloak;

    public List<UserRepresentation> getUsers() {

        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();

        return usersResource.list();
    }

    public UserRepresentation getUser(String username) {

        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersResource = realmResource.users();
        List<UserRepresentation> users = usersResource.search(username, true);

        return users.isEmpty() ? null : users.get(0);
    }

    public void createUser(UserDTO userDTO) {
        CredentialRepresentation credential =
                Credentials.createPasswordCredentials(userDTO.getPassword());

        UserRepresentation user = new UserRepresentation();

        user.setUsername(userDTO.getUserName());
        user.setFirstName(user.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(user.getEmail());
        user.setCredentials(Collections.singletonList(credential));
        user.setEnabled(true);
        user.setEmailVerified(true);

        UsersResource usersResource = keycloak.realm(realm).users();
        usersResource.create(user);
        user = usersResource.search(user.getUsername()).get(0);

//        keycloak.realm(realm).users().get(user.getId());

        UserResource userResource =
                keycloak.realm(realm).users().get(user.getId());

        // Get client
        ClientRepresentation app1Client = keycloak.realm(realm).clients() //
                .findByClientId(clientId).get(0);
        for (String role : userDTO.getRoles()) {
            // Get client level role (requires view-clients role)
            RoleRepresentation userClientRole = keycloak.realm(realm).clients()
                    .get(app1Client.getId())
                    .roles().get(role).toRepresentation();

            // Assign client level role to user
            userResource.roles() //
                    .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));
        }
    }

    public void updatePassword(String userID) {

        UsersResource usersResource = keycloak.realm(realm).users();
        UserRepresentation userRepresentation = usersResource.search(userID, true)
                .stream().findFirst().orElse(null);

        if(userRepresentation != null) {
            UserResource userResource = usersResource.get(userRepresentation.getId());
            userResource.executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));

            return;
        }
        throw new ScolariteException("User not found !");
    }
}
