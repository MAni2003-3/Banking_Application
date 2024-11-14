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

import com.mysql.cj.Session;

import dao.UserDao;

@WebServlet("/forget")
public class ForgetPassword extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		String email =(String) session.getAttribute("email");
		System.out.println(email);
		if(email.equals(req.getParameter("email")) && req.getParameter("new_password").equals(req.getParameter("confirm_password"))) {
			UserDao u = new UserDao();
			try {
				u.forgotPaaword(req.getParameter("email"),req.getParameter("new_password"));
				RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
				dis.include(req, resp);
			} catch (SQLException e) {
				e.printStackTrace();
				RequestDispatcher dis = req.getRequestDispatcher("forgetpassword.jsp");
				dis.include(req, resp);
			}
		}else {
			req.setAttribute("password", "password not matched");
			RequestDispatcher dis = req.getRequestDispatcher("forgetpassword.jsp");
			dis.include(req, resp); 
		}
	}
}
