package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.User;
import util.Database;

public class UserDAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    public boolean doRegister(User user) {
        String sql = "insert into login (username, email, password) values (?,?,?)";
        con = Database.getConnection();
        System.out.println("hi");

        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            int status = ps.executeUpdate();
            System.err.println(status);
            if (status > 0) {
                System.out.println(user.getPassword());
                return true;
            }
        } catch (Exception e) {
        }

        System.out.println("........" + user.getPassword());
        return false;
    }

    public boolean doLogin(User user) {
        String sql = "select * from login where username= ?";
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            rs = ps.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public List<User> getAll() {
        List<User> users = new ArrayList<User>();
        String sql = "select * from login";
        con = Database.getConnection();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");
                String password = rs.getString("password");
                User u = new User();
                u.setUsername(username);
                u.setEmail(email);
                u.setPassword(password);
                users.add(u);
            }
        } catch (Exception e) {
        }
        return users;
    }
}
