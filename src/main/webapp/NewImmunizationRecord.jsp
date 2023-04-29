<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Immunization Record</title>
<link rel="stylesheet" type="text/css" href="styles.css" />
</head>
<body>
	<div class="some-page-wrapper">
		<div class="row">
			<div class="column">
				<div class="nav-column">
					<h1>Child Immunization</h1>
					<form action="NewImmuneRec.html">
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
					<h2>Immunization Record</h2>
					
					<% 
					 String name = (String) request.getAttribute("name");
					 String sex = (String) request.getAttribute("sex");
					 String dob = (String) request.getAttribute("dob");
					 
					 String dne = (String) request.getAttribute("dne");
					%>

					<c:if test="${!(empty inputError.msg)}">
						<p style="color: red">
							Error :
							<c:out value="${inputError.msg}" />
						</p>
						<jsp:setProperty name="inputError" property="msg" value="" />
					</c:if>
					
					<c:if test="${!(empty dne)}">
						<p style="color: red">
							Error :
							<c:out value="${dne}" />
						</p>
					</c:if>
					


					<form method="post" action="findNhis.jsp">
						<h3>NHIS #</h3>
						<input name="nhisnum" type="number">
						<button type="submit" id="findBtn">Find</button>
					</form>

					<h3>Name</h3>
					<input id="childName" type="text" value="<%=name%>" disabled>
					<h3>Sex</h3>
					<input type="text" value="<%=sex%>"disabled>
					<h3>DOB</h3>
					<input type="date" value="<%=dob %>" disabled>
					<h3>Weight</h3>
					<input type="number">

					<h3>Vaccine</h3>
					<select>
						<option value="BCG">BCG</option>
						<option value="Penta">Pentavalent</option>
						<option value="Pneumo">Pneumo</option>
						<option value="Polio">Polio</option>
						<option value="Rotarix">Rotarix</option>
						<option value="YF">Yellow Fever</option>
						<option value="Vitamin A">Vitamin A</option>
					</select>
					<h3>Remarks</h3>
					<textarea rows="5" cols="33"></textarea>
					<div style="margin-top: 1.5em">
						<button type="button" id="addVax">Add Vax</button>
						<button type="button" id="subVax">Submit Record</button>
						<button type="button" id="clrBtn">Clear</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>