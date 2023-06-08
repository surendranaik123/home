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

@WebServlet("/Delete")
public class Delete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

			System.out.println("connection done");

			PreparedStatement ps = con.prepareStatement("delete from CoustermerReg where id = ?");
			  int id = Integer.parseInt(request.getParameter("id"));
                    ps.setInt(1, id);
                    
                    int count = ps.executeUpdate();
                    if(count==1) {
                        pw.println("<h2 class='bg-danger text-light text-center'>Record Deleted Successfully</h2>");
                    }else {
                        pw.println("<h2 class='bg-danger text-light text-center'>Record Not Deleted</h2>");
                    }

		} catch (Exception e) {

			e.printStackTrace();
			
		}
		
	        pw.close();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
