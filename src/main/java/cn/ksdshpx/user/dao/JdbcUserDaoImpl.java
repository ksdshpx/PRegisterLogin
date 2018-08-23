package cn.ksdshpx.user.dao;

import cn.ksdshpx.user.domain.User;
import cn.ksdshpx.user.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Create with IntelliJ IDEA
 * Create by peng.x
 * Date: 2018/8/23
 * Time: 14:50
 * Description:加入Jdbc代码
 */
public class JdbcUserDaoImpl implements UserDao {

    /**
     * 按用户名查询
     *
     * @param username
     * @return
     */
    public User findByUsername(String username) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "SELECT * FROM t_user WHERE username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAge(rs.getInt("age"));
                user.setGender(rs.getString("gender"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
        return user;
    }

    /**
     * 添加用户
     *
     * @param user
     */
    public void add(User user) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "INSERT INTO t_user(username,password,age,gender) VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            pstmt.setInt(3, user.getAge());
            pstmt.setString(4, user.getGender());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(conn, pstmt, rs);
        }
    }
}
