<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
	<head>
		<title>
			CustomerList
		</title>
		
		<link type="text/css" rel=stylesheet href="${pageContext.request.contextPath}/resources/css/style.css">
		
	</head>
	
	<body>

		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer RelationShip Manager</h2>
			</div>
		</div>

		<div id="container">
			<div id="content">
				
				<input type="button" value="Add Customer" onclick="window.location.href='showFormForAdd'; return false;" class="add-button"/>
				
				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>
					
					<c:forEach var="tempCustomer" items="${customers }">
					
					<!-- Construct an update link with customer id -->
						<c:url var="updateLink" value="/customer/showFormForUpdate">
							<c:param name="customerId" value="${tempCustomer.id}"/>
						</c:url>
					
						<tr>
							<td>${tempCustomer.first_name}</td>
							<td>${tempCustomer.last_name}</td>
							<td>${tempCustomer.email}</td>	
							<td>
								<!-- Display update link -->
								<a href="${updateLink}">Update</a>
							</td>																			
						</tr>						
					
					</c:forEach>
					
				</table>
				
				
			</div>
		</div>


	</body>
	
</html>