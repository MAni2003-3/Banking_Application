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
@WebServlet("/updateData")
public class getUserDataToUpdate extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao u = new UserDao();
		HttpSession s = req.getSession(false);
		try {
			req.setAttribute("profile", u.getUserData((String) s.getAttribute("email")));
			RequestDispatcher dis = req.getRequestDispatcher("update.jsp");
			dis.forward(req, resp);
		} catch (SQLException e) {
			e.printStackTrace();
			RequestDispatcher dis = req.getRequestDispatcher("update.jsp");
			dis.forward(req, resp);
		}
	}
}
