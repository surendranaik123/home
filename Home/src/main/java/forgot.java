import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;

@WebServlet("/forgot")
public class forgot extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String conformpassword = request.getParameter("conformpassword");

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("connection done");
			PreparedStatement pst = con.prepareStatement("update suri set password=? where email=?");

			pst.setString(2, email);
			pst.setString(1, password);
			pst.setString(1, conformpassword);

			int i = pst.executeUpdate();
			
			if (i > 0) {
				
					if ((password ==conformpassword )) {
						
						jakarta.servlet.RequestDispatcher requestDispatcher = request
								.getRequestDispatcher("Login.html");
						requestDispatcher.forward(request, response);

					} else {
						jakarta.servlet.RequestDispatcher requestDispatcher = request
								.getRequestDispatcher("UpdateFailed.html");
						requestDispatcher.forward(request, response);
					}
				
				} else {
					out.print("hello");
				}
			
			/*
			 * 
			 * if(conformpassword!= null && !conformpassword.equals(password)) {
			 * jakarta.servlet.RequestDispatcher requestDispatcher =
			 * request.getRequestDispatcher("Login.html");
			 * requestDispatcher.forward(request, response); } else {
			 * jakarta.servlet.RequestDispatcher requestDispatcher =
			 * request.getRequestDispatcher("UpdateFailed.html");
			 * requestDispatcher.forward(request, response); }
			 * 
			 * 
			 * 
			 * 
			 * 
			 * if (i>0) {
			 * 
			 * jakarta.servlet.RequestDispatcher requestDispatcher =
			 * request.getRequestDispatcher("Login.html");
			 * requestDispatcher.forward(request, response); } else {
			 * 
			 * jakarta.servlet.RequestDispatcher requestDispatcher =
			 * request.getRequestDispatcher("UpdateFailed.html");
			 * requestDispatcher.forward(request, response); }
			 */
			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
