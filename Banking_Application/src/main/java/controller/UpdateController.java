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
import dto.UserDto;

@WebServlet("/update")
public class UpdateController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao u = new UserDao();
		HttpSession s = req.getSession(false);
		try {
			u.updateUser(new UserDto(req.getParameter("Fname"), req.getParameter("Lname"), (String) s.getAttribute("email"), Long.parseLong(req.getParameter("phno")),"", req.getParameter("DOB"), req.getParameter("gender"), req.getParameter("address")));
			RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
			dis.forward(req, resp);
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			RequestDispatcher dis = req.getRequestDispatcher("update.jsp");
			dis.include(req, resp);
		}
	}
}
