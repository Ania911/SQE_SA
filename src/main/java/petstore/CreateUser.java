package petstore;

import java.util.ArrayList;
import java.util.List;

public class CreateUser {
    private String userName;
    private String password;
    private List<CreateUser> userList;

    public CreateUser() {
        userList = new ArrayList<>();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUser(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void addUsersToList(List<CreateUser> userList, String username, String password, int numberOfUsers) {
        for (int i = 0; i < numberOfUsers; i++) {
            CreateUser newUser = new CreateUser();
            newUser.setUserName(username);
            newUser.setPassword(password);
            userList.add(newUser);
        }
    }

}
