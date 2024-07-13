package com.easesuccess.momgodb.operations;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eseyoursuccess.momgodb.dao.UserDAO;
import com.mongodb.MongoClient;

import model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/addUser")
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		 
		if((name == null || name.equals(""))
				||(email == null || email.equals(""))
				||(password == null || password.equals(""))){
			request.setAttribute("error", "All fields are required");
			RequestDispatcher reqDes = getServletContext().getRequestDispatcher("/users.jsp");
			reqDes.forward(request, response);
		}else {
			
			User u = new User();
			u.setName(name);
			u.setEmail(email);
			u.setPassword(password);
			
			MongoClient mongo = (MongoClient) request.getServletContext().getAttribute("MONGO_CLIENT");
			UserDAO userDAO = new UserDAO(mongo);
			userDAO.createUser(u);			
			request.setAttribute("success", "User Added");
			
			List<User> users = userDAO.readAllUsers();
			request.setAttribute("users", users);
			
			RequestDispatcher reqDes = getServletContext().getRequestDispatcher("/users.jsp");
			reqDes.forward(request, response);
		}

	}
	

}
