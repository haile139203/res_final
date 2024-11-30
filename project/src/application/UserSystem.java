package application;

import dao.Role;
import dto.response.UserResponse;

public class UserSystem {
    private UserResponse userData;

    public UserSystem(UserResponse userResponse) {
        userData = userResponse;
    }

    public String getFirstName() {
        return userData.getFirstName();
    }

    public String getLastName() {
        return userData.getLastName();
    }

    public String getFullName() {
        return userData.getFirstName() + " " + userData.getLastName();
    }

    public Role getRole() {
        return userData.getRole();
    }
}
