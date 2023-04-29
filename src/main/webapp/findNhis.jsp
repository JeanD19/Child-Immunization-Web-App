<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException, java.sql.Statement, java.sql.ResultSet"%>

<!-- Validation of NHIS number -->

<jsp:useBean id="inputError" class="domain.InputError" scope="session">
</jsp:useBean>

<c:if test="${empty fn:trim(param.nhisnum)}">
	<jsp:setProperty name="inputError" property="msg"
		value="NHIS number is empty. Please enter again." />
	<jsp:forward page="NewImmunizationRecord.jsp" />
</c:if>

<%
//Step 1: Connect to DB
// Database connection parameters
String url = "jdbc:postgresql://localhost:5432/ImmunizationData"; // Replace with your database URL
String user = "postgres"; // Replace with your username
String password = "LiwangaSQL2023$"; // Replace with your password

// Load the PostgreSQL JDBC driver
Class.forName("org.postgresql.Driver");

// Establish a connection to the PostgreSQL server
Connection conn = DriverManager.getConnection(url, user, password);

//Step 2: Allocate a 'Statement' object in the Connection
Statement stmt = conn.createStatement();

String nhisnum = request.getParameter("nhisnum");

String sqlStr = "select * from patients where nhis = '" + nhisnum + "'";
ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server

if(rset.next()){
	String patientName = rset.getString("name");
	String patientSex = rset.getString("sex");
	String patientDob = rset.getString("dob");
	
	
	request.setAttribute("name", patientName);
	request.setAttribute("sex", patientSex);
	request.setAttribute("dob", patientDob);

	
	System.out.println(patientName + " " + patientSex + " " + patientDob);
	// Forward the request to index.html
	RequestDispatcher dispatcher = request.getRequestDispatcher("NewImmunizationRecord.jsp");
	dispatcher.forward(request, response);
}
//id doesn't exists
else {
	String dnemsg = "This nhis number does not exists in this table!";
	request.setAttribute("dne", dnemsg);
	RequestDispatcher dispatcher = request.getRequestDispatcher("NewImmunizationRecord.jsp");
	dispatcher.forward(request, response);
	
}

%>
