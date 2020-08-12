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
			<h2>Log Stats</h2>
			<table>						
				<tr>
					<td> Past 24h </td>	
					<td> ${logStats.get(0)} </td>					
				</tr>
				<tr>
					<td> Past week </td>	
					<td> ${logStats.get(1)} </td>					
				</tr>
				<tr>
					<td> All time </td>	
					<td> ${logStats.get(2)} </td>					
				</tr>		
			</table>
			
			<br><br>
			
			<h2>Most Searched For</h2>
			<table>
				<tr>
					<th>Company</th>
					<th>Count</th>
				</tr>
				
				<c:forEach var="record" items="${topSearchedCompanies}">			
					<tr>
						<td> ${record[0]} </td>
						<td> ${record[1]} </td>						
					</tr>		
				</c:forEach>
			</table>
			
			<br><br>
			
			<h2>Recent Logs (past 24hrs)</h2>
			<table>
				<tr>
					<th>Company</th>
					<th>Search Log</th>
				</tr>
				
				<c:forEach var="record" items="${recentLogs}">			
					<tr>
						<td> ${record[0]} </td>
						<td> ${record[1]} </td>						
					</tr>		
				</c:forEach>
			</table>
				
		</div>
	</div>
</body>
</html>









