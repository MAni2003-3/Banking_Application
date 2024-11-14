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
import dto.BankDto;
import dto.UserDto;

@WebServlet("/createaccount")
public class CreateAccountController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("pin").equals(req.getParameter("confrim_pin"))) {
			BankDao b = new BankDao();
			UserDao u = new UserDao();
			HttpSession s = req.getSession(false);
			UserDto user;
			try {
				user = u.getUserData((String) s.getAttribute("email"));
				b.saveBank(new BankDto(req.getParameter("type"), req.getParameter("branch"),Double.parseDouble(req.getParameter("balance")), Long.parseLong(req.getParameter("pin")),user.getPhNo(),(String) s.getAttribute("email")));
				RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
				dis.forward(req, resp);
			} catch (SQLException | NumberFormatException | ClassNotFoundException e) {
				e.printStackTrace();
				req.setAttribute("message", "Account already created");
				RequestDispatcher dis = req.getRequestDispatcher("createaccount.jsp");
				dis.include(req, resp);
			}
		}
	}
}
