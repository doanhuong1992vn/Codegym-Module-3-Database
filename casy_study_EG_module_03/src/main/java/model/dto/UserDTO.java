package model.dto;

public class UserDTO {
    private final String loginName;
    private final String password;

    public UserDTO(String loginName, String password) {
        this.loginName = loginName;
        this.password = password;
    }

    public String getLoginName() {
        return loginName;
    }

    public String getPassword() {
        return password;
    }
}
