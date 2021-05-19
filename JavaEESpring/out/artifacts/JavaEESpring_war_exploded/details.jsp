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
        <div class="row">
            <div class="col-6 mx-auto">
                <%
                    Films film = (Films) request.getAttribute("film");
                    if (film != null) {
                %>
                <form action="/savefilm" method="post">
                    <input type="hidden" name = "id" value="<%=film.getId()%>">
                    <div class="mt-3">
                        <label>
                            NAME:
                        </label>
                        <input type="text" class="form-control" placeholder="Name of film" name="film_name" required value="<%=film.getName()%>">
                    </div>
                    <div class="mt-3">
                        <label>
                            DESCRIPTION:
                        </label>
                        <textarea type="text" class="form-control" placeholder="Description of film" name="film_description" required><%=film.getDescription()%></textarea>
                    </div>
                    <div class="mt-3">
                        <label>
                            COUNTRY:
                        </label>
                        <select class="form-control" name="film_country">
                            <%
                                ArrayList<Countries> countries = (ArrayList<Countries>) request.getAttribute("countries");
                                if (countries != null) {
                                    for (Countries c : countries) {
                            %>
                            <option value="<%=c.getId()%>" <% if (c.getId() == film.getCountry().getId()){out.print("selected");}%>>
                                <%=c.getName() + " / " + c.getCode()%>
                            </option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>
                    <div class="mt-3">
                        <label>
                            DURATION:
                        </label>
                        <select class="form-control" name="film_duration">
                            <%
                                for (int i = 1; i <= 400; i++) {
                             %>
                                <option value="<%out.print(i);%>" <%if (film.getDuration() == i){out.print("selected");}%>>
                                    <% out.print(i + "mins");%>
                                </option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <div class="mt-3">
                        <label>
                            GENRE:
                        </label>
                        <select class="form-control" name="film_genre">
                            <option <%if (film.getGenre().equals("HORROR")){out.print("selected");}%>>HORROR</option>
                            <option <%if (film.getGenre().equals("ACTION")){out.print("selected");}%>>ACTION</option>
                            <option <%if (film.getGenre().equals("DRAMA")){out.print("selected");}%>>DRAMA</option>
                            <option <%if (film.getGenre().equals("COMEDY")){out.print("selected");}%>>COMEDY</option>
                            <option <%if (film.getGenre().equals("FANTASY")){out.print("selected");}%>>FANTASY</option>
                            <option <%if (film.getGenre().equals("OTHER")){out.print("selected");}%>>OTHER</option>
                        </select>
                    </div>
                    <div class="mt-3">
                        <button class="btn btn-success">SAVE FILM</button>
                    </div>
                </form>
                <form action="/deletefilm" method="post">

                    <input type="hidden" name = "id" value="<%=film.getId()%>">
                    <button class="btn btn-danger">DELETE FILM</button>

                </form>
                <!-- Button trigger modal -->
                <button type="button" class="btn btn-primary" onclick="showModal()">
                    Launch static backdrop modal
                </button>

                <!-- Modal -->
                <div class="modal fade" id="staticBackdrop" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="staticBackdropLabel">Modal title</h5>
                                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                            </div>
                            <div class="modal-body">
                                ...
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                                <button type="button" class="btn btn-primary">Understood</button>
                            </div>
                        </div>
                    </div>
                </div>
                <%
                    } else {
                %>
                    <h1 class="text-center">404 NOT FOUND</h1>
                <%
                    }
                %>
            </div>
        </div>
    </div>
    <script src="./bootstrap/js/bootstrap.min.js" type="text/javascript">

        function showModal() {
            let myModal = document.getElementById('staticBackdrop');
            myModal.show();
        }

    </script>
</body>
</html>
