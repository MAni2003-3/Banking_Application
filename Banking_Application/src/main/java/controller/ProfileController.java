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
import dto.ProfileDto;
import dto.UserDto;

@WebServlet("/profile")
public class ProfileController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserDao u = new UserDao();
		BankDao b =new BankDao();
		HttpSession s = req.getSession(false);
		System.out.println(s.getAttribute("email"));
		try {
			UserDto userDetails = u.getUserData((String) s.getAttribute("email"));
			BankDto bankDetails = b.getBankDetails((String) s.getAttribute("email"));
			req.setAttribute("profile", new ProfileDto(userDetails.getfName()+" "+userDetails.getlName(), bankDetails.getAccountNumber(), bankDetails.getIFSCCode(), userDetails.getPhNo(), bankDetails.getBranch(), userDetails.getAddress()));
			RequestDispatcher dis = req.getRequestDispatcher("profile.jsp");
			dis.forward(req, resp);
		} catch (SQLException | ClassNotFoundException e) {
			req.setAttribute("message", "No bank account Found");
			RequestDispatcher dis = req.getRequestDispatcher("profile.jsp");
			dis.forward(req, resp);
		}
	}
}
