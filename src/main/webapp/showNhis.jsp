<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page import="java.sql.Connection, java.sql.DriverManager, java.sql.SQLException, java.sql.Statement, java.sql.ResultSet"%>
<%@ page import="java.util.ArrayList, java.util.List" %>

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

int nhisnum = Integer.parseInt(request.getParameter("nhisnum"));

String sqlStr = "select * from patients where nhis = '" + nhisnum + "'";
ResultSet rset1 = stmt.executeQuery(sqlStr); // Send the query to the server

String patientName = rset1.getString("name");

sqlStr = "select * from immunerecords where nhis = '" + nhisnum + "'";
ResultSet rset = stmt.executeQuery(sqlStr); // Send the query to the server



List<String> vaccines = new ArrayList<String>();
List<String> remarks = new ArrayList<String>();
List<String> datesOfVax = new ArrayList<String>();

//id doesn't exists
if(rset.getRow() == 0){
	String dnemsg = "This nhis number does not exists in this table!";
	request.setAttribute("dne", dnemsg);
	RequestDispatcher dispatcher = request.getRequestDispatcher("ViewImmuneRec.jsp");
	dispatcher.forward(request, response);
}

while (rset.next()) {
	vaccines.add(rset.getString("vaccine"));
	remarks.add(rset.getString("remarks"));
	datesOfVax.add(rset.getString("date"));
}

request.setAttribute("vaxes", vaccines);
request.setAttribute("name", patientName);
request.setAttribute("remarks", remarks);
request.setAttribute("dates", datesOfVax);


System.out.println(nhisnum + " " + patientName + " " + vaccines + " " + remarks + " " + datesOfVax);

RequestDispatcher dispatcher = request.getRequestDispatcher("ViewImmuneRec.jsp");
dispatcher.forward(request, response);

%>