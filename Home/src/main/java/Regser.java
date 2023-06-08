import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
public class Regser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
	
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into suri values(?,?,?,?,?)");

			ps.setString(1, fname);
			ps.setString(2, lname);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, password);
			
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
	}

}
