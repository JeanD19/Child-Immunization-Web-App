<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Immunizations</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<div class="some-page-wrapper">
		<div class="row">
			<div class="column">
				<div class="nav-column">
					<h1>Child Immunization</h1>
					<form action="NewImmunizationRecord.jsp">
						<button>New Immunization Record</button>
					</form>
					<br /> <br />
					<form action="ViewImmuneRec.jsp">
						<button>View Immunization Record</button>
					</form>
					<br /> <br />
					<form action="MonthlyReport.jsp">
						<button>Monthly Report</button>
					</form>
				</div>
			</div>
			<div class="four-column">
				<div class="content-column">
					<h2>View Immunization Records</h2>
					<c:if test="${!(empty dne)}">
						<p style="color: red">
							Error :
							<c:out value="${dne}" />
						</p>
					</c:if>
					<form action="showNhis.jsp" method="post">
						<h3>NHIS #</h3>
						<input type="number" name="nhisnum">
						<button type="submit" id="findBtn">Find</button>
					</form>
					
					<%
						//Create a table to display all the vaccines, the remarks, and the dates
						
					
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>