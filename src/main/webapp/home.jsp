<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>Site under construction</title>
</head>

<body>
	<h4>Site under construction</h4>
	<hr>
	
	<p>
	<h4>Welcome!</h4>
	</p>

    <p>
    User: <security:authentication property="principal.username"/>
    <br><br>
    Role(s): <security:authentication property="principal.authorities"/>
    </p>

    <security:authorize access="hasAnyRole('EMPLOYEE','MANAGER','ADMIN')">
    <p>

	<a href="${pageContext.request.contextPath}/api/customers">Customers List</a>
    <br><br>

    </p>
    </security:authorize>



    <security:authorize access="hasAnyRole('MANAGER','ADMIN')">
        <p>

            <a href="${pageContext.request.contextPath}/api/employees">Employee List</a>
            <br><br>


        </p>
    </security:authorize>
    <!-- MENGEER -->

    <security:authorize access="hasRole('MANAGER')">
    
    <p>
        <a href="${pageContext.request.contextPath}/leaders"> Leadership Meeting(For Menagers and Admins)</a>

    </p>
    </security:authorize>

    <!-- ADMIN -->
    <security:authorize access="hasRole('ADMIN')">
    <p>
        <a href="${pageContext.request.contextPath}/admins"> Admins Page (Only For Admins)</a>

    </p>
    </security:authorize>

    <br><br>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
	
</body>

</html>









