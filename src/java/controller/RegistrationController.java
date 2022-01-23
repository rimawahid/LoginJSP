package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.UserService;

@WebServlet(name = "RegistrationController", urlPatterns = {"/register", "/"})
public class RegistrationController extends HttpServlet {

    UserService userService;

    @Override
    public void init() throws ServletException {
        super.init(); //To change body of generated methods, choose Tools | Templates.
        userService = new UserService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        boolean status = userService.doRegister(req);
        System.out.println(status);
        if (status == true) {
            
            req.getRequestDispatcher("view/registration.jsp").forward(req, resp);
        } else {
            System.out.println("hello");
            req.getRequestDispatcher("view/error.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("view/registration.jsp").forward(req, resp);
    }
}
