package com.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email").toLowerCase();
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher = null;
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authentication?useSSL=false", "root", "root");

			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			pst.setString(1, email);

			ResultSet res = pst.executeQuery();
			if (res.next()) {
				if (res.getString("user_password").equals(password)) {
					session.setAttribute("name", res.getString("name"));
					dispatcher = request.getRequestDispatcher("index.jsp");
				}
				else {
					request.setAttribute("status", "passwordFailed");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
			}
			else {
				request.setAttribute("status", "emailFailed");
				dispatcher = request.getRequestDispatcher("register.jsp");
			}
			dispatcher.forward(request, response);
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
