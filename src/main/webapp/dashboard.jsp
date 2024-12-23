<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String scheme = request.getScheme();
    String serverName = request.getServerName();
    int serverPort = request.getServerPort();
    String contextPath = request.getContextPath();
    String formUrl = scheme + "://" + serverName + ":" + serverPort + contextPath + "/";
%>
<!DOCTYPE html>
<html lang="en">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>

    <div class="container">

    <h1>Cars</h1>

    <br>

    <a href="<%= formUrl %>">Home</a>

    <hr>

<!--
    <table class="table">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
        </thead>

        <tbody>
            <c:forEach var="car" items="${cars}">
                <tr>
                    <td>${car.name}</td>
                    <td>${car.color}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div>
-->

    <div class="container">

        <div class="row">
            <c:forEach var="car" items="${cars}">
              <div class="col-sm-6 mb-3 mb-sm-0">
                <div class="card">
                  <div class="card-body">
                    <h5 class="card-title">${car.name}</h5>
                    <p class="card-text">${car.color}</p>
                    <a href="#" class="btn btn-primary">Go somewhere</a>
                    <br>
                    <form action="/delete-car" method="post">
                        <input type="hidden" id="id" name="id" value="${car.id}">
                        <button type="submit" class="btn btn-danger">Delete</button>
                    </form>

                    <span> | </span>

                    <a href="index.jsp?id=${car.id}&name=${car.name}&color=${car.color}">Update</a>

                  </div>
                </div>
                <br>
              </div>

            </c:forEach>
        </div>

    </div>

</body>
</html>