package gov.iti.jets.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
public class User {
    @NotNull(message = "name must not be null")
    @Size(min = 3, max = 50, message = "name must be between 3 and 50")
    String name;
    @NotNull(message = "email must not be null")
    @Email(message = "please enter valid mail")
    String email;
    @Size(min = 10, max = 50, message = "password must be between 3 and 50")
    String password;


}
