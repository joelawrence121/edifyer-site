<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "java.util.Date" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>

<html>

<head>

<%
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  String date = sdf.format(new Date());
%>

	<title>Analytics </title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/templatestyle.css" />

</head>

<h1>Analytics <%=date%></h1>

<body>
	
	<div id="container">	
		<div id="content">	
			<h2>Recent Logs (past 24hrs)</h2>
			<table>
				<tr>
					<th>Company Id</th>
					<th>Date</th>
				</tr>
				
				<!-- loop over and print companies -->
				<c:forEach var="recentLog" items="${recentLogs}">			
					<tr>
						<td> ${recentLog.company_id} </td>
						<td> ${recentLog.date} </td>						
					</tr>		
				</c:forEach>
			</table>
				
		</div>
	</div>
</body>
</html>









