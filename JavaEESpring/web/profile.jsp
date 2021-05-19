index.jsp<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group32.db.Films" %>
<%@ page import="kz.bitlab.group32.db.Countries" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/bootstrap/css/bootstrap.min.css">
</head>
<body>
    <div class="container">
        <%@include file="navbar.jsp"%>
    </div>
    <div class="container">
        <%
            if (currentUser != null) {

        %>
        <div class="row mt-5">
            <div class="col-6 mx-auto">
             <h2 class="text-center">
                 <%=currentUser.getFullName()%>
             </h2>
            </div>
        </div>
        <%

            }

        %>
    </div>
</body>
</html>
