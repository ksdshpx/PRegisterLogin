package cn.ksdshpx.user.exception;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/1
 * Time: 10:21
 * Description:用户自定义异常
 */
public class UserException extends Exception{
    public UserException() {
    }

    public UserException(String message) {
        super(message);
    }
}
