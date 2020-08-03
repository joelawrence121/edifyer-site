<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List</title>
	
	<!-- reference our style sheet -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/templatestyle.css" />

</head>

<body>
	
	<div id="container">	
		<div id="content">	
			<h2>Sources</h2>
			<table>
				<tr>
					<th>Id</th>
					<th>Name</th>
					<th>Script</th>
					<th>Home Link</th>
				</tr>
				
				<!-- loop over and print companies -->
				<c:forEach var="tempSource" items="${sources}">			
					<tr>
						<td> ${tempSource.id} </td>
						<td> ${tempSource.name} </td>
						<td> ${tempSource.scrapeScript} </td>
						<td> ${tempSource.homeLink} </td>
						
					</tr>		
				</c:forEach>
			</table>
			<br><br><br>
			<h2>Ratings</h2>
			<table>
				<tr>
					<th>Id</th>
					<th>Company</th>
					<th>Source</th>
					<th>Rate</th>
					<th>Uncertainty</th>
					<th>Date</th>
					<th>Source Link</th>
				</tr>
				
				<!-- loop over and print companies -->
				<c:forEach var="tempRating" items="${ratings}">			
					<tr>
						<td> ${tempRating.id} </td>
						<td> ${tempRating.company.name} </td>
						<td> ${tempRating.source.name} </td>
						<td> ${tempRating.sdrate} </td>
						<td> ${tempRating.uncertainty} </td>
						<td> ${tempRating.date} </td>
						<td> ${tempRating.sourceLink} </td>
					</tr>		
				</c:forEach>
			</table>
			<br><br><br>
			<h2>Companies</h2>
			<table>
				<tr>
					<th>Company Id</th>
					<th>Name</th>
					<th>Category</th>
				</tr>
				
				<!-- loop over and print companies -->
				<c:forEach var="tempCompany" items="${companies}">			
					<tr>
						<td> ${tempCompany.id} </td>
						<td> ${tempCompany.name} </td>
						<td> ${tempCompany.category} </td>
						
					</tr>		
				</c:forEach>
			</table>
				
		</div>
	</div>
</body>
</html>









