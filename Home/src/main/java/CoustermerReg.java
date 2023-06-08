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
@WebServlet("/CoustermerReg")
public class CoustermerReg extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into CoustermerReg(NAME,MOBILE,EMAIL,Password) values(?,?,?,?)");

			ps.setString(1, name);
			ps.setString(2, mobile);
			ps.setString(3, email);
			ps.setString(4, password);
			
			ps.executeUpdate();
			if (ps.equals(ps)) {
				
				jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Sucess.html");
				requestDispatcher.forward(request, response);
		
			} else {

				out.print("not exsisted");
			}
			
			
		} catch (Exception e) {

			jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Failed.html");
			requestDispatcher.forward(request, response);
			e.printStackTrace();
		}
		out.print("HEllO");
	}

}
