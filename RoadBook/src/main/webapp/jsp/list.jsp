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
    <style type="text/css">
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
        table {
            border-collapse: collapse; /* Убираем двойные линии между ячейками */
            text-align: center;
        }
        td, th {
            padding: 3px; /* Поля вокруг содержимого таблицы */
            border: 1px solid black; /* Параметры рамки */
        }
        th {
            background: #b0e0e6; /* Цвет фона */
        }
    </style>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div style="margin: auto; width: 45%">
        <div class="table">
            <table>
                <div class="column-header">
                    <tr>
                        <td>Country</td>
                        <td>Number</td>
                        <td>Name</td>
                        <td>Long(km)</td>
                        <td>Control</td>
                        <td></td>
                    </tr>
                </div>
                <c:forEach items="${list}" var="item">
                    <tr>
                        <td>${item.country}</td>
                        <td>${item.number}</td>
                        <td>${item.name}</td>
                        <td>${item.longer}</td>
                        <td>${item.control}</td>
                        <td>
                            <div class="btn-group-vertical">
                                <a href="edit?id=${item.id}"  class="btn btn-success btn-sm btn-block">Edit</a>
                                <form method="post" action="delete">
                                    <input type="hidden" name="id" value="${item.id}">
                                    <input type="submit" class="btn btn-danger btn-sm btn-block" value="Delete">
                                </form>
                            </div>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div>
            <a href="add"  class="btn btn-success btn-lg btn-block">Add</a>
        </div>
    </div>

   <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
   <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>