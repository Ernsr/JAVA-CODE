<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>
        Session IS

        <%
            String data = (String) request.getAttribute("text_data");
            out.print(data);

        %>
    </h1>
    <form action="/session" method="post">
        Name: <input type="text" name="name">
        Surname: <input type="text" name="surname">
        Age: <input type="number" name="age">
        <button>CREATE SESSION</button>
    </form>
</body>
</html>
