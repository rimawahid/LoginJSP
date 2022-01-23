
package service;

import dao.UserDAO;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import model.User;

public class UserService {
    public boolean doRegister (HttpServletRequest req){
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        System.out.println(req.getParameter("username"));
        return new UserDAO().doRegister(user);
    }
    
    public boolean doLogin(HttpServletRequest req){
        User user = new User();
        user.setUsername(req.getParameter("username"));
        user.setEmail(req.getParameter("email"));
        user.setPassword(req.getParameter("password"));
        return new UserDAO().doLogin(user);
    }
    
    public List<User> getAll(){
        return new UserDAO().getAll();
    }
}
