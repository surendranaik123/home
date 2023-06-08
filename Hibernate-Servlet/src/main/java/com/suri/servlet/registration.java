package com.suri.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.suri.model;
import com.suri.pojo.user;

public class registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException
	, IOException {
		PrintWriter out = response.getWriter();
		

		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phoneno = request.getParameter("phoneno");
		String salary = request.getParameter("salary");
		String addr = request.getParameter("addr");
		String country = request.getParameter("country");
		String language = request.getParameter("language");


		RequestDispatcher requestDispatcher = null;
		try {

			user user = new user();
			user.setName(name);
			user.setEmail(email);
			user.setPassword(password);
			user.setPhoneno(phoneno);
			user.setSalary(salary);
			user.setAddr(addr);
			user.setCountry(country);
			user.setLanguage(language);
			
			
			model model=new model();
			model.datapage(user);

		
			if (user.equals(user)) {
				out.print("sucess!!");
			}
		
			else {
			out.print("failde!!");
		}
			
		} catch (Exception e) {
			e.printStackTrace();
			requestDispatcher = request.getRequestDispatcher(".html");
			requestDispatcher.forward(request, response);
		}
		
		

	}

}
