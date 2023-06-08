package com.suri.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suri.model;
import com.suri.pojo.user;

public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		try {

			user user = new user();
			user.setEmail(email);
			user.setPassword(password);
           model model=new model();
			//com.suri.model model = new model();
			model.datafetch(email, password);

			if (user.equals(user)) {
				out.print("sucess");
			} else {

				out.print("Sorry username or password error");
			}

		} catch (Exception e) {
			out.print(" error");
			e.printStackTrace();
		}
		
		finally {
			out.close();
		}
	}

}
