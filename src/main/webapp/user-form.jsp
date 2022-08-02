<%--
  Created by IntelliJ IDEA.
  User: hirunima_s
  Date: 8/1/2022
  Time: 2:02 AM
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
            <a class="navbar-brand"> Student Management App </a>
        </div>

        <ul class="navbar-nav">
            <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Students</a></li>
        </ul>
    </nav>
</header>
<br>
<div class="container col-md-5">
    <div class="card">
        <div class="card-body">
            <c:if test="${Student != null}">
            <form action="update" method="post">
                </c:if>
                <c:if test="${Student == null}">
                <form action="insert" method="post">
                    </c:if>

                    <caption>
                        <h2>
                            <c:if test="${Student!= null}">
                                Edit Record
                            </c:if>
                            <c:if test="${Student == null}">
                                Add New Record
                            </c:if>
                        </h2>
                    </caption>

                    <c:if test="${Student != null}">
                        <input type="hidden" name="ID" value="<c:out value='${Student.id}' />"/>
                    </c:if>

                    <fieldset class="form-group">
                        <label>Student Name</label> <input type="text" value="<c:out value='${Student.name}' />"
                                                           class="form-control" name="StudentName" required="required">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Student Age</label> <input type="text" value="<c:out value='${Student.age}' />"
                                                          class="form-control" name="StudentAge">
                    </fieldset>

                    <fieldset class="form-group">
                        <label>Student Email</label> <input type="text" value="<c:out value='${Student.email}' />"
                                                            class="form-control" name="StudentEmail">
                    </fieldset>

                    <button type="submit" class="btn btn-success">Save</button>
                </form>
        </div>
    </div>
</div>
</body>

</html>
