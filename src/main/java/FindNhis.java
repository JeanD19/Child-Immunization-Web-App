
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.sql.*;
//import jakarta.servlet.*;            // Tomcat 10
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import javax.servlet.*;            // Tomcat 9
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/findNhis")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class FindNhis extends HttpServlet{

	// The doGet() runs once per HTTP GET request to this servlet.
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		//To be completed...
		try {
			// Step 1: Allocate a database 'Connection' object
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ImmunizationData", "postgres", "LiwangaSQL2023$");

			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();
			
			//Step 3: Execute a SQL SELECT query
			String sqlStr = "select * from patients where nhis = "
					+ "'" + request.getParameter("nhisnum") + "'";   // Single-quote SQL string;
			
			System.out.println(sqlStr);

		} catch(Exception ex) {
			//out.println("<p>Error: " + ex.getMessage() + "</p>");
			//out.println("<p>Check Tomcat console for details.</p>");
			ex.printStackTrace();
		}
	}
}
