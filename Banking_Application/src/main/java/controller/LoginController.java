package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;

@WebServlet("/login")
public class LoginController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao u = new UserDao();
		try {
			if(u.login(req.getParameter("email"), req.getParameter("password")).equals("success")){
				HttpSession session = req.getSession(false);
				session.setAttribute("email", req.getParameter("email"));
				session.setAttribute("password", req.getParameter("password"));	
				RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
				dis.forward(req, resp);
			}else if(u.login(req.getParameter("email"), req.getParameter("password")).equals("passwordWrong")) {
				req.setAttribute("password", "Invalid password");
				RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
				dis.include(req, resp);
			}else {
				req.setAttribute("email", "Invalid email");
				RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
				dis.include(req, resp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
