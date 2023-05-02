

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

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

/**
 * Servlet implementation class addVax
 */
@WebServlet("/addVax")
public class addVax extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//To be completed...
		try {
			// Step 1: Allocate a database 'Connection' object
			Class.forName("org.postgresql.Driver");
			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ImmunizationData", "postgres", "LiwangaSQL2023$");

			// Step 2: Allocate a 'Statement' object in the Connection
			Statement stmt = conn.createStatement();

			//Step 3: Get the inputs passed in from the New Immunization Record
			int nhis = Integer.parseInt(request.getParameter("nhisnum"));  //would be an int when pushed into DB
			double weight = Double.parseDouble(request.getParameter("weight"));
			String vaccineRecvd = request.getParameter("vaxes");
			String remarks = request.getParameter("remarks");
			
			//Add a row into Immunization Record table
			// Create a transaction record
			String sqlStr = "INSERT INTO ImmuneRecords (nhis, vaccine, remarks, weight, date) "
					+ "VALUES (" + nhis + ", '" + vaccineRecvd + "', '"+ remarks +  "', '"+ weight + "', CURRENT_DATE)";
			
			stmt.execute(sqlStr);
			System.out.println("Successfully added a record");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("NewImmunizationRecord.jsp");
	        dispatcher.forward(request, response);

		} catch(Exception ex) {
			//out.println("<p>Error: " + ex.getMessage() + "</p>");
			//out.println("<p>Check Tomcat console for details.</p>");
			ex.printStackTrace();
		}

	}







	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
