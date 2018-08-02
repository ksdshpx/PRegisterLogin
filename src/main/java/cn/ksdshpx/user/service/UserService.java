package cn.ksdshpx.user.service;

import cn.ksdshpx.user.dao.UserDao;
import cn.ksdshpx.user.domain.User;
import cn.ksdshpx.user.exception.UserException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/7/31
 * Time: 10:19
 * Description:业务处理类UserService
 */
public class UserService {
    private UserDao userDao = new UserDao();

    /**
     * 注册功能
     *
     * @param user
     */
    public void register(User user) throws UserException {
        //1.判断该用户是否已经被注册
        User _user = userDao.findByUsername(user.getUsername());
        if (_user != null) {
            throw new UserException("用户:" + user.getUsername() + "已经被注册！");
        }
        //2.添加用户
        userDao.add(user);
    }

    /**
     * 登录功能
     *
     * @param form
     * @return
     */
    public User login(User form) throws UserException {
        User _user = userDao.findByUsername(form.getUsername());
        if (_user == null) {
            throw new UserException("用户名错误!");
        }
        if (!_user.getPassword().equals(form.getPassword())) {
            throw new UserException("密码错误");
        }
        return _user;
    }
}
