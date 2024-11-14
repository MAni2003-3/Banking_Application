package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BankDao;

@WebServlet("/balance")
public class BalanceController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getParameter("pin").equals(req.getParameter("confirmPin"))) {
			BankDao b = new BankDao();
			try {
				double balance = b.balance(Long.parseLong(req.getParameter("phno")), Long.parseLong(req.getParameter("pin")));
				req.setAttribute("balance", balance);
				RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
				dis.forward(req, resp);
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
				req.setAttribute("message", "Invalid phone number or pin");
				RequestDispatcher dis = req.getRequestDispatcher("balance.jsp");
				dis.include(req, resp);
			}
		}else {
			req.setAttribute("message", "Invalid phone number or pin");
			RequestDispatcher dis = req.getRequestDispatcher("balance.jsp");
			dis.include(req, resp);
		}
	}
}
