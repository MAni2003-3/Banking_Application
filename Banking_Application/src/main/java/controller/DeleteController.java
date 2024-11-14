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

import dao.BankDao;
import dao.UserDao;

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao u = new UserDao();
		BankDao b = new BankDao();
		HttpSession s = req.getSession(false);
		if(((String)s.getAttribute("email")).equals(req.getParameter("email")) && ((String)s.getAttribute("password")).equals(req.getParameter("password"))) {
			try {
				u.deleteUser(req.getParameter("email"));
				b.deleteBank(req.getParameter("email"));
				s.invalidate();
				RequestDispatcher dis = req.getRequestDispatcher("index.jsp");
				dis.forward(req, resp);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
				req.setAttribute("message", "Invalid email or password");
				RequestDispatcher dis = req.getRequestDispatcher("delete.jsp");
				dis.include(req, resp);
			}
		}else {
			req.setAttribute("message", "Invalid email or password");
			RequestDispatcher dis = req.getRequestDispatcher("delete.jsp");
			dis.include(req, resp);
		}
	}
}
