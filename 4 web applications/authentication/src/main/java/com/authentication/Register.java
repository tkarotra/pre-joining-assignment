package com.authentication;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email").toLowerCase();
		String phoneNumber = request.getParameter("phoneNumber");
		String countryCode = request.getParameter("countryCode");
		String countryName = request.getParameter("countryName");
		String countryNameCode = request.getParameter("countryNameCode");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		RequestDispatcher dispatcher = null;
		Connection con = null;

		if (!Pattern.matches("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}", email)) {
			System.out.print(Pattern.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}", email));
			request.setAttribute("status", "emailError");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if (!Pattern.matches("[A-Za-z]{2,} [A-Za-z]{2,}", name)) {
			request.setAttribute("status", "nameError");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if (phoneNumber == null || phoneNumber.equals("") || countryName == null || countryName.equals("") || countryNameCode == null || countryNameCode.equals("") || countryCode == null || countryCode.equals("")) {
			request.setAttribute("status", "phoneNumberError");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if (!Pattern.matches("(?=.*\\d)(?=.*[!@#$%^&*])(?=.*[a-z])(?=.*[A-Z]).{8,}", password)) {
			request.setAttribute("status", "passwordError");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		if (!password.equals(confirmPassword)) {
			request.setAttribute("status", "confirmPasswordError");
			dispatcher = request.getRequestDispatcher("register.jsp");
			dispatcher.forward(request, response);
		}
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/authentication?useSSL=false", "root", "root");

			PreparedStatement pst = con.prepareStatement("SELECT * FROM users WHERE email = ?");
			pst.setString(1, email);
			ResultSet res = pst.executeQuery();
			if (res.next()) {
				request.setAttribute("status", "emailFailed");
				dispatcher = request.getRequestDispatcher("login.jsp");
			}
			else {
				pst = con.prepareStatement("INSERT INTO users (name, email, country, country_code_name, country_code, phone_number, user_password) VALUES (?, ?, ?, ?, ?, ?, ?)");
				pst.setString(1, name);
				pst.setString(2, email);
				pst.setString(3, countryName);
				pst.setString(4, countryNameCode);
				pst.setString(5, countryCode);
				pst.setString(6, phoneNumber);
				pst.setString(7, password);
				
				int rowCount = pst.executeUpdate();
				if (rowCount > 0) {
					request.setAttribute("status", "registrationSuccess");
					dispatcher = request.getRequestDispatcher("login.jsp");
				}
				else {
					request.setAttribute("status", "dbFailed");
					dispatcher = request.getRequestDispatcher("register.jsp");
				}
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
