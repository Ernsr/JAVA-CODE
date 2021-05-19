<%@ page import="java.util.ArrayList" %>
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
        <div class="row mt-5">
            <div class="col-6 mx-auto">
                <%
                    String error = request.getParameter("error");
                    if (error!= null) {
                %>
                <div class="alert alert-danger alert-dismissible fade show" role="alert">
                    Incorrect email or password,try again!
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
                <%
                    }
                %>
                <form action="/login" method="post">
                    <div class="mt-3">
                        <label>
                            EMAIL:
                        </label>
                        <input type="email" class="form-control mt-3" name="email" required placeholder="User Email">
                    </div>
                    <div class="mt-3">
                        <label>
                            PASSWORD:
                        </label>
                        <input type="password" class="form-control mt-3" name="password" required placeholder="User Password">
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-dark">SIGN IN</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
<script src="./bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
</html>
