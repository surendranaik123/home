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
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		 
		 try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				System.out.println("connection done");
				PreparedStatement pst = con.prepareStatement("select id,name,mobile,email,password from coustermerreg");

				out.print("<table style='margin:auto;width:900px;margin-top:100px;' width=100% border=2>");
				out.print("<caption><h1>Coustermer Detiles:</h1></caption>");

				ResultSet rs = pst.executeQuery();
				out.print("<tr>");
				out.print("<th>Id</th>");
				out.print("<th>Name</th>");
				out.print("<th>Mobile</th>");
				out.print("<th>Email</th>");
				out.print("<th>Password</th>");
				out.print("<th>Edit</th>");
				out.print("<th>Delete</th>");
				out.print("</tr>");
				while (rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt(1)+"</td>");
					out.print("<td>"+rs.getString(2)+"</td>");
					out.print("<td>"+rs.getString(3)+"</td>");
					out.print("<td>"+rs.getString(4)+"</td>");
					out.print("<td>"+rs.getString(5)+"</td>");
					out.println("<td><a href='Edit?id="+rs.getInt(1)+"'>Edit</a></td>");
	                out.println("<td><a href='Delete?id="+rs.getInt(1)+"'>Delete</a></td>");
					
					
					out.print("</tr>");
					
				}
				
				out.print("</table>");

			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				out.close();
			}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();


	
		 
		 try {

				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
				System.out.println("connection done");
				PreparedStatement pst = con.prepareStatement("select id,name,mobile,email,password from coustermerreg");

				out.print("<table style='margin:auto;width:900px;margin-top:100px;' width=100% border=2>");
				out.print("<caption><h1>Coustermer Detiles:</h1></caption>");

				ResultSet rs = pst.executeQuery();
				out.print("<tr>");
				out.print("<th>Id</th>");
				out.print("<th>Name</th>");
				out.print("<th>Mobile</th>");
				out.print("<th>Email</th>");
				out.print("<th>Password</th>");
				out.print("<th>Edit</th>");
				out.print("<th>Delete</th>");
				out.print("</tr>");
				while (rs.next()) {
					out.print("<tr>");
					out.print("<td>"+rs.getInt(1)+"</td>");
					out.print("<td>"+rs.getString(2)+"</td>");
					out.print("<td>"+rs.getString(3)+"</td>");
					out.print("<td>"+rs.getString(4)+"</td>");
					out.print("<td>"+rs.getString(5)+"</td>");
					out.println("<td><a href='Edit?id="+rs.getInt(1)+"'>Edit</a></td>");
	                out.println("<td><a href='Delete?id="+rs.getInt(1)+"'>Delete</a></td>");
					
					
					out.print("</tr>");
					
				}
				
				out.print("</table>");

			} catch (Exception e2) {
				e2.printStackTrace();
			} finally {
				out.close();
			}
		}

}
