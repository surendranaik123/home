import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/Adminreg")
public class Adminreg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw=response.getWriter();
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("insert into Admin(NAME,EMAIL,Password) values(?,?,?)");

			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, password);
			
			ps.executeUpdate();
			if (ps.equals(ps)) {
				
				jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Sucess.html");
				requestDispatcher.forward(request, response);
		
			} else {

				pw.print("not exsisted");
			}
			
			
		} catch (Exception e) {

			jakarta.servlet.RequestDispatcher	 requestDispatcher = request.getRequestDispatcher("Failed.html");
			requestDispatcher.forward(request, response);
			e.printStackTrace();
		}
		pw.print("Hello");
	}

}
