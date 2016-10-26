<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Vojts
  Date: 25.10.2016
  Time: 0:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Failure</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
<div class="container" style="margin-left: 200px; margin-top: 40px;">
    <header>
        <h2>Fail operation!!!</h2>
        <p><c:out value="${error}"/></p>
        <p>Try again</p>
    </header>
    <article>
        <a href="${action}" class="btn btn-success btn-lg"><i class="icon-next">Ok</i></a>
    </article>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
