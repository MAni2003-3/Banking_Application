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

import dao.TransactionDao;
import dto.TransactionDto;

@WebServlet("/transfer")
public class TransferController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TransactionDao t = new TransactionDao();
		HttpSession s = req.getSession(false);
		try {
			double balance = t.trasferAmount(new TransactionDto(Long.parseLong(req.getParameter("accountNumber")), req.getParameter("ifscCode"), Integer.parseInt(req.getParameter("amount")), Long.parseLong(req.getParameter("pin")),(String) s.getAttribute("email")));
			if(balance!=0) {
				req.setAttribute("balance", balance);
				RequestDispatcher dis = req.getRequestDispatcher("home.jsp");
				dis.forward(req, resp);
			}
			else {
				req.setAttribute("message", "Invalid details");
				RequestDispatcher dis = req.getRequestDispatcher("transfer.jsp");
				dis.include(req, resp);
			}
		} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			req.setAttribute("message", "Invalid details");
			RequestDispatcher dis = req.getRequestDispatcher("transfer.jsp");
			dis.include(req, resp);
		}
	}
}
