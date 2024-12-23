<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();
    String contextPath = request.getContextPath();
    String formUrl = scheme + "://" + serverName + ":" + serverPort + contextPath;
%>
<html>
    <head>
        <title>Home</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">

            <h2>Hello World, turma 3D!</h2>

            <form action="<%= formUrl %>/create-car" method="post">

                <input type="hidden" name="id" value="${param.id}">

                <div  class="mb-3">
                    <label for="car-name" class="form-label">Name:</label>
                    <input type="text" name="car-name" id="car-name" value="${param.name}" class="form-control">
                </div>

                <div  class="mb-3">
                    <label for="color" class="form-label">Color:</label>
                    <input type="text" name="color" id="color" value="${param.color}" class="form-control">
                </div>

                <button class="btn btn-primary" type="submit">Save</button>

            </form>

        </div>

    </body>
</html>
