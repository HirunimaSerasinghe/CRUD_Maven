<%--
  Created by IntelliJ IDEA.
  User: hirunima_s
  Date: 8/1/2022
  Time: 2:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>
    <title>Student Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>

<body>

<header>
    <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #477cff">
        <div>
            <a href="https://www.javaguides.net" class="navbar-brand"> Student
                Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
        </ul>
    </nav>
</header>
<br>

<div class="row">

    <div class="container">
        <h3 class="text-center">List of Students</h3>
        <hr>
        <div class="container text-left">

            <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
                New Record</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Email</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>

            <c:forEach var="Student" items="${listStudent}">

                <tr>
                    <td>
                        <c:out value="${Student.id}"/>
                    </td>
                    <td>
                        <c:out value="${Student.name}"/>
                    </td>
                    <td>
                        <c:out value="${Student.age}"/>
                    </td>
                    <td>
                        <c:out value="${Student.email}"/>
                    </td>
                    <td><a href="edit?ID=<c:out value='${Student.id}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a
                            href="delete?ID=<c:out value='${Student.id}' />">Delete</a></td>
                </tr>
            </c:forEach>

            </tbody>

        </table>
    </div>
</div>
</body>

</html>