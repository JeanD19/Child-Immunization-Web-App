<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException, java.sql.Statement, java.sql.ResultSet"%>

<!-- Send data to the DB -->

<%
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

%>