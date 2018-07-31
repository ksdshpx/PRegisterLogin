package cn.ksdshpx.user.domain;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/31
 * Time: 10:10
 * Description:用户实体类User
 */
public class User {
    private String username;
    private String password;
    private String verifyCode;

    public User() {
    }

    public User(String username, String password, String verifyCode) {
        this.username = username;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
