package cn.ksdshpx.user.dao;

import cn.ksdshpx.user.domain.User;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/23
 * Time: 14:31
 * Description:UserDao接口
 */
public interface UserDao {
    public abstract User findByUsername(String username);

    public abstract void add(User user);
}
