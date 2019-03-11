<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>


<head>
    <title>Site under construction</title>
    <link href='<spring:url value="/resources/css/style.css"/>' rel="stylesheet"/>
    <script src="/resources/statics/js/jquery-3.3.1.min.js"></script>

</head>

<body>
<div id="main">
    <div id="header">
        <div id="logo">
            <div id="logo_text">
                <!-- class="logo_colour", allows you to change the colour of the text -->
                <h1><a href="${pageContext.request.contextPath}/">Blan<span class="logo_colour">Tube</span></a></h1>
                <h2>Simple. Contemporary. Website Template.</h2>
            </div>
        </div>
        <div id="menubar">
            <ul id="menu">
                <!-- put class="selected" in the li tag for the selected page - to highlight which page you're on -->
                <li class="selected"><a href="index.html">Home</a></li>
                <li><a href="examples.html">Examples</a></li>
                <li><a href="page.html">A Page</a></li>
                <li><a href="another_page.html">Another Page</a></li>
                <li><a href="contact.html">Contact Us</a></li>

            </ul>
        </div>
    </div>
    <div id="site_content">
        <div class="sidebar">
            <!-- insert your sidebar items here -->
            <p>
                User: <security:authentication property="principal.username"/>
                <br><br>
                Role(s): <security:authentication property="principal.authorities"/>
            </p>
            <p>
                <form:form action="${pageContext.request.contextPath}/logout"
                           method="POST">

                    <input type="submit" value="Logout"/>

                </form:form>
            </p>
            <h3>Useful Links</h3>
            <ul>
                <li><a href="#">link 1</a></li>
                <li><a href="#">link 2</a></li>
                <li><a href="#">link 3</a></li>
                <li><a href="#">link 4</a></li>
            </ul>
            <h3>Search</h3>
            <form method="post" action="#" id="search_form">
                <p>
                    <input class="search" type="text" name="search_field" value="Enter keywords....."/>
                    <input name="search" type="image" style="border: 0; margin: 0 0 -9px 5px;" src="style/search.png"
                           alt="Search" title="Search"/>
                </p>
            </form>
        </div>
        <div id="content">


        </div>
        <div id="footer">
            Copyright &copy; black_white | <a href="http://validator.w3.org/check?uri=referer">HTML5</a> | <a
                href="http://jigsaw.w3.org/css-validator/check/referer">CSS</a> | <a
                href="http://www.html5webtemplates.co.uk">Free CSS Templates</a>
        </div>
    </div>
</body>
</html>









