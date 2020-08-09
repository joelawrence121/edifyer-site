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
			<h2>Company</h2>
			<table>
				<tr>
					<th>Company Id</th>
					<th>Name</th>
					<th>Category</th>
				</tr>
						
					<tr>
						<td> ${theCompany.id} </td>
						<td> ${theCompany.name} </td>
						<td> ${theCompany.category} </td>
						
					</tr>		
			</table>
			<br><br>
			<h2>${theCompany.name} Ratings</h2>
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
				<c:forEach var="tempRating" items="${theCompany.ratings}">			
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
		</div>
	</div>
</body>
</html>









