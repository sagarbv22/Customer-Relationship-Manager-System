<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ListCustomers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
</head>
<body>
	<center>
		<div id="wrapper">
			<div id="header">
				<h2>CRM - Customer Relationship Manager</h2>
			</div>
		</div>

		<div id="container">
			<div id="content">

				<!-- put new button:: Add Customer -->
				<input type='button' value='Add Customer'
					onclick="window.location.href='showForm'; return false;"
					class="add-button" />

				<table>
					<tr>
						<th>First Name</th>
						<th>Last Name</th>
						<th>Email</th>
						<th>Action</th>
					</tr>

					<c:forEach items="${customers}" var="customer">
						<c:url var="updatelink" value="showFormForUpdate">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<c:url var="deletelink" value="deleteCustomer">
							<c:param name="customerId" value="${customer.id}" />
						</c:url>
						<tr>
							<td>${customer.firstName}</td>
							<td>${customer.lastName}</td>
							<td>${customer.email}</td>
							<td><a href="${updatelink}">UPDATE</a> | <a
								href="${deletelink}"
								onclick="if(!(confirm('Are you sure u want to delete this customer?')))return false;">DELETE</a>
						</tr>

					</c:forEach>


				</table>

			</div>
		</div>


	</center>
</body>
</html>