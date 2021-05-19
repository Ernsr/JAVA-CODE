<%@ page import="kz.bitlab.group32.db.Countries" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>
    <%
        String name = (String) request.getAttribute("cookies_name");
        String surname = (String) request.getAttribute("cookies_surname");
        String age = (String) request.getAttribute("cookies_age");
        String country = (String) request.getAttribute("cookies_country");
        String gender = (String) request.getAttribute("cookies_gender");
        String credit = (String) request.getAttribute("cookies_credit");

    %>
</h1>
<form action="/cookies" method="post">
    <div class="container">
        <div class="row mt-5">
            <div class="mt-5">
                <lable>
                    Name :
                </lable>
                <input type="text" class="form-control" name="cookies_name" value="<%out.print(name);%>">
            </div>
            <div class="mt-5">
                <lable>
                    Surname :
                </lable>
                <input type="text" name="cookies_surname" value="<%out.print(surname);%>">
            </div>
            <div class="mt-5">
                <label>
                    Age :
                </label>
                <input type="number" name="cookies_age" value="<%out.print(age);%>">
            </div>
            <div class="mt-5">
                <label>
                    Country :
                </label>
                <input type="text" name="cookies_country" value="<%out.print(country);%>">
            </div>
            <div class="mt-5">
                <label>
                    Gender :
                </label>
                <input type="text" name="cookies_gender" value="<%out.print(gender);%>">
            </div>
            <div class="mt-5">
                <label>
                    Credit Card :
                </label>
                <input type="text" name="cookies_credit" value="<%out.print(credit);%>">
            </div>

            <button class="btn btn-success">Save</button>
        </div>
    </div>
</form>
<a href="/removecookies">Remove Cookies</a>

</body>
</html>
