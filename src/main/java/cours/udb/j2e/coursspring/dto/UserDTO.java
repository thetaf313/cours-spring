package cours.udb.j2e.coursspring.dto;

import lombok.Data;

import java.util.List;

@Data
public class UserDTO {

    private String userName;
    private String emailId;
    private String password;
    private String firstname;
    private String lastName;
    private List<String> roles;
}
