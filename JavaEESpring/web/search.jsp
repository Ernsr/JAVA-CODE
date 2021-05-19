<%@ page import="java.util.ArrayList" %>
<%@ page import="kz.bitlab.group32.db.Films" %>
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
    <div class="container mt-5">
        <div class="row">
            <div class="col-12">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>NAME</th>
                            <th>DESCRIPTION</th>
                            <th>COUNTRY</th>
                            <th>DURATION</th>
                            <th>GENRE</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            ArrayList<Films> films = (ArrayList<Films>) request.getAttribute("foundFilms");
                            if (films != null) {
                                for (Films f : films) {
                        %>
                            <tr>
                                <td>
                                    <%
                                        out.print(f.getName());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(f.getDescription());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(f.getCountry());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(f.getDuration());
                                    %>
                                </td>
                                <td>
                                    <%
                                        out.print(f.getGenre());
                                    %>
                                </td>
                            </tr>
                        <%
                                }
                            }

                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</body>
</html>
