import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class loginser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		String email = request.getParameter("email");
		String password = request.getParameter("password");

		request.setAttribute("email", email);
		request.setAttribute("password", password);

		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			System.out.println("connection done");
			PreparedStatement pst = con.prepareStatement("select * from suri where email=? and password=?");

			pst.setString(1, email);
			pst.setString(2, password);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {

				jakarta.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.html");
				requestDispatcher.forward(request, response);
			} else {

				jakarta.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("Failed.html");
				requestDispatcher.forward(request, response);
			}

			out.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
