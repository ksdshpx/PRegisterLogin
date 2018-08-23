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
    private Integer age;
    private String gender;
    private String verifyCode;

    public User() {
    }

    public User(String username, String password, Integer age, String gender) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.gender = gender;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", verifyCode='" + verifyCode + '\'' +
                '}';
    }
}
