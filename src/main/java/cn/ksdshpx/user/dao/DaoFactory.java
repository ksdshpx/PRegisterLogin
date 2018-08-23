package cn.ksdshpx.user.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/23
 * Time: 14:34
 * Description:Dao工厂类
 */
public class DaoFactory {
    private static Properties props;
    static {
        //加载bean.properties配置文件
        try {
            InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props = new Properties();
            props.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private DaoFactory() {
    }

    public static UserDao getUserDao() {
        String className = props.getProperty("cn.ksdshpx.user.dao.UserDao");
        UserDao userDao = null;
        try {
            Class clazz = Class.forName(className);
            userDao = (UserDao) clazz.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userDao;
    }
}
