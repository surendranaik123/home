import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.annotation.WebServlet;

@WebServlet("/Edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw = response.getWriter();
	       
	       try {
	    	   Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");

				System.out.println("connection done");

				PreparedStatement ps = con.prepareStatement(" select name,mobile,email,password from CoustermerReg where id=?");
				
				int id = Integer.parseInt(request.getParameter("id"));
				 ps.setInt(1, id);
		        ResultSet rs = ps.executeQuery();
		                 rs.next();
		                 pw.println("<center>");
		                 pw.println("<tr>");
		                 pw.println("<div style='margin:auto;width:500px;margin-top:100px;'>");
		                 pw.println("<form action='EditUser?id="+id+"' method='post'>");
		                 pw.println("<table class='table table-hover table-striped'>");
		                 
		                 pw.println("User Edit Option");
		                 pw.println("<br>");
		                 pw.println("=============");
		             
		                 pw.println("<tr>");
		                 pw.println("<td>Name</td>");
		                 pw.println("<td><input type='text' name='name' value='"+rs.getString(1)+"'></td>");
		                 pw.println("</tr>");
		                 pw.println("<tr>");
		                 pw.println("<td>Mobile</td>");
		                 pw.println("<td><input type='text' name='mobile' value='"+rs.getString(2)+"'></td>");
		                 pw.println("</tr>");
		                 pw.println("<tr>");
		                 pw.println("<td>Email</td>");
		                 pw.println("<td><input type='email' name='email' value='"+rs.getString(3)+"'></td>");
		                 pw.println("</tr>");
		                 pw.println("<tr>");
		                 pw.println("<td>Password</td>");
		                 pw.println("<td><input type='text' name='password' value='"+rs.getString(4)+"'></td>");
		                 pw.println("<br>");
		                 pw.println("</tr>");
		                 pw.println("<td><button type='submit' class='btn btn-outline-success'>Edit</button></td>");
		                 pw.println("</table>");
		                 pw.println("</form>");
		                 pw.println("</div>");
		                 pw.println("</center>");
		                 
		} catch (Exception e) {
			e.printStackTrace();
			pw.close();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
