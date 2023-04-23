// To save as "ebookshop\WEB-INF\classes\QueryServlet.java".
import java.io.*;
import java.sql.*;
//import jakarta.servlet.*;            // Tomcat 10
//import jakarta.servlet.http.*;
//import jakarta.servlet.annotation.*;
import javax.servlet.*;            // Tomcat 9
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/immuneRec")   // Configure the request URL for this servlet (Tomcat 7/Servlet 3.0 upwards)
public class NewImmuneRec extends HttpServlet {

	// The doGet() runs once per HTTP GET request to this servlet.
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//MAJOR STEP: WRITE OUT THE HTML FORMAT (text, inputs, etc)
		// Set the MIME type for the response message
		response.setContentType("text/html");

		// Get a output writer to write the response message into the network socket
		PrintWriter out = response.getWriter();
		// Print an HTML page as the output of the query
		out.println("<html>");
		out.println("<head>");
		out.println("<title>New Immunization Record</title>");
		out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"styles.css\" />");
		out.println("</head>");
		out.println("<body>");

		out.println("<div class=\"some-page-wrapper\">");
		out.println("<div class=\"row\">");
		out.println("<div class=\"column\">");
        out.println("<div class=\"nav-column\">");
        out.println("<h1>Child Immunization</h1>");
        out.println("<form method=\"get\" action=\"immuneRec\">");
        out.println("<button>New Immunization Record</button>");
        out.println("</form>");
        out.println("<br /> <br />");
        out.println("<form action=\"ViewImmuneRec.jsp\">");
        out.println("<button>View Immunization Record</button>");
        out.println("</form>");
        out.println("<br /> <br />");
        out.println("<form action=\"MonthlyReport.jsp\">");
        out.println("<button>Monthly Report</button>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");
        out.println("<div class=\"four-column\">");
        out.println("<div class=\"content-column\">");
        out.println("<h2> Immunization Record </h2>");
        out.println("<h3> NHIS #</h3>");
        out.println("<input type=\"number\">");
        out.println("<input type=\"submit\" value=\"Find\">");
        out.println("<h3> Name</h3>");
        out.println("<input type=\"text\">");
        out.println("<h3> Sex</h3>");
        out.println("<input type=\"text\">");
        out.println("<h3> Age</h3>");
        out.println("<input type=\"number\">");
        out.println("<h3> Vaccine</h3>");
        out.println("<select>");
        out.println("<option value=\"BCG\"> BCG </option>");
        out.println("<option value=\"Penta\"> Pentavalent </option>");
        out.println("<option value=\"Pneumo\"> Pneumo </option>");
        out.println("<option value=\"Polio\"> Polio </option>");
        out.println("<option value=\"Rotarix\"> Rotarix </option>");
        out.println("<option value=\"YF\"> Yellow Fever </option>");
        out.println("<option value=\"Vitamin A\"> Vitamin A </option>");
        out.println("</select>");
        out.println("<h3> Remarks</h3>");
        out.println("<textarea rows=\"5\" cols=\"33\" >");
        out.println("</textarea>");
        out.println("<div style=\"margin-top: 1.5em\">");
        out.println("<button type=\"button\" id=\"addVax\"> Add Vax </button>");
        out.println("<button type=\"button\" id=\"subVax\"> Submit Record </button>");
        out.println("<button type=\"button\" id=\"clrBtn\"> Clear </button>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
		
		
		out.println("</body>");
		out.println("</html>");
		out.close();

//		try {
//			// Step 1: Allocate a database 'Connection' object
//			Class.forName("org.postgresql.Driver");
//			Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/ImmunizationData", "postgres", "LiwangaSQL2023$");
//
//			// Step 2: Allocate a 'Statement' object in the Connection
//			Statement stmt = conn.createStatement();
//			
//
//
//		} catch(Exception ex) {
//			out.println("<p>Error: " + ex.getMessage() + "</p>");
//			out.println("<p>Check Tomcat console for details.</p>");
//			ex.printStackTrace();
//		}
	}
}