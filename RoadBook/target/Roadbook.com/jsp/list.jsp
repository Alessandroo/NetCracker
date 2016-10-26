<%--
  Created by IntelliJ IDEA.
  User: Vojts
  Date: 25.10.2016
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>RoadList</title>
    <%--<style>--%>
        <%--a {--%>
            <%--text-decoration: none; /* Отменяем подчеркивание у ссылки */--%>
        <%--}--%>
    <%--</style>--%>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <c:forEach items="${list}" var="item">
            <h2><c:out value="${item.id}"/></h2>
        </c:forEach>
    </div>
   <%--<div class="page-list">--%>
       <%--<table aria-orientation="horizontal">--%>
           <%--<tr>--%>
               <%--<td><a href="list?page=1">1</a></td>--%>
               <%--<td><a href="list?page=2">2</a></td>--%>
               <%--<td><a href="list?page=3">3</a></td>--%>
           <%--</tr>--%>
       <%--</table>--%>
   <%--</div>--%>
   <%--<div class="table">--%>
       <%--<table style="border: double">--%>
           <%--<div class="column-header">--%>
               <%--<tr>--%>
                   <%--<td>Страна</td>--%>
                   <%--<td>Номер</td>--%>
                   <%--<td>Название</td>--%>
                   <%--<td>Длина(км)</td>--%>
                   <%--<td>Управляется</td>--%>
                   <%--<td></td>--%>
               <%--</tr>--%>
           <%--</div>--%>
           <%--<tr>--%>
               <%--<td>Беларусь</td>--%>
               <%--<td>М1</td>--%>
               <%--<td>Брест-Орша</td>--%>
               <%--<td>645</td>--%>
               <%--<td>Белавтодор</td>--%>
               <%--<td>--%>
                   <%--<div class="btn-group-vertical">--%>
                       <%--<a href="edit?id="  class="btn btn-success btn-sm btn-block">Edit</a>--%>
                       <%--<a href="delete?id=" class="btn btn-danger btn-sm btn-block">Delete</a>--%>
                   <%--</div>--%>
               <%--</td>--%>
           <%--</tr>--%>
       <%--</table>--%>
   <%--</div>--%>
   <%--<div>--%>
       <%--<a href="add"  class="btn btn-success btn-lg btn-block">Add</a>--%>
   <%--</div>--%>

   <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
   <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
