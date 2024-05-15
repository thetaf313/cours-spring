package cours.udb.j2e.coursspring.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String username;
    private String password;
}