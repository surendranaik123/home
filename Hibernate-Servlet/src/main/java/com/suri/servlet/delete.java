package com.suri.servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.suri.model;
import com.suri.pojo.user;

public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@SuppressWarnings("unlikely-arg-type")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException {
       PrintWriter out = response.getWriter();
		
		
		String name = request.getParameter("name");
		
		
		try {
			
			user user=new user();
			user.setName(name);
			
			model model = new model();
			model.deletedata(user);
			
			if (user.equals(user.getName())) {
				out.print("delete sucess");
			} else {
				out.print("delete failed");
			}
			
		
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
