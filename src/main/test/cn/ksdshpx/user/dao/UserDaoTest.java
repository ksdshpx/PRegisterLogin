package cn.ksdshpx.user.dao;

import cn.ksdshpx.user.domain.User;
import org.junit.Test;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/1
 * Time: 9:45
 * Description:Dao层单元测试
 */
public class UserDaoTest {

    @Test
    public void testFindByUsername() {
        UserDao userDao = new UserDao();
        User user = userDao.findByUsername("赵六");
        System.out.println(user);
    }

    @Test
    public void testAdd() {
        UserDao userDao = new UserDao();
        User user = new User();
        user.setUsername("王五");
        user.setPassword("wangWu");
        userDao.add(user);
    }
}
