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
    <style>
        a {
            text-decoration: none; /* Отменяем подчеркивание у ссылки */
        }
    </style>
</head>
<body>
   <div class="page-list">
       <table aria-orientation="horizontal">
           <tr>
               <td><a href="list?page=1">1</a></td>
               <td><a href="list?page=2">2</a></td>
               <td><a href="list?page=3">3</a></td>
           </tr>
       </table>
   </div>
   <div class="table">
       <table>
           <div class="column-header">
               <tr>
                   <td>Страна</td>
                   <td>Номер</td>
                   <td>Название</td>
                   <td>Длина(км)</td>
                   <td>Управляется</td>
                   <td></td>
               </tr>
           </div>
           <tr>
               <td>Беларусь</td>
               <td>М1</td>
               <td>Брест-Орша</td>
               <td>645</td>
               <td>Белавтодор</td>
               <td>
                   <a href="edit?id=1">Edit</a>
                   <br>
                   <a href="delete?id=1">Edit</a>
               </td>
           </tr>
       </table>
   </div>
   <div>
       <div style="background: chartreuse"><a href="add">Add</a></div>
   </div>


</body>
</html>
