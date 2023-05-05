package gov.iti.jets;

import gov.iti.jets.model.User;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data

public class UserService {
    @Getter
    private static List<User> users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
