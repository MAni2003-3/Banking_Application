package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.UserDao;
import dto.UserDto;

@WebServlet("/register")
public class RegisterController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("password")!=null && req.getParameter("password").equals(req.getParameter("confrimpassword"))) {
			UserDao userDao = new UserDao();
			UserDto user = new UserDto(req.getParameter("Fname"),req.getParameter("Lname"), req.getParameter("email"), Long.parseLong(req.getParameter("phno")), req.getParameter("password"), req.getParameter("DOB"), req.getParameter("gender"), req.getParameter("address"));
			try {
				userDao.saveUser(user);
				RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
				dis.include(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
				req.setAttribute("email", "User already exits");
				RequestDispatcher dis = req.getRequestDispatcher("register.jsp");
				dis.include(req, resp);
			}
			
		}else {
			req.setAttribute("password", "password not matched");
			RequestDispatcher dis = req.getRequestDispatcher("register.jsp");
			dis.include(req, resp);
		}
	}
}
