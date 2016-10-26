<%--
  Created by IntelliJ IDEA.
  User: Vojts
  Date: 25.10.2016
  Time: 0:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>RecordForm</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>
<body>
    <div class="container">
        <form method="post" action="${action}">
            <h2>Please enter the data</h2>
            <input type="text" name="country" class="form-control" placeholder="Country" value="${record.country}" required>
            <input type="text" name="number" class="form-control" placeholder="Number" value="${record.number}" required>
            <input type="text" name="name" class="form-control" placeholder="Name" value="${record.name}" required>
            <input type="text" name="longer" class="form-control" placeholder="Long(km)" value="${record.longer}" required>
            <input type="text" name="control" class="form-control" placeholder="Control" value="${record.control}" required>
            <input type="hidden" name="id" value="${record.id}">
            <input type="submit" name="Ok" class="btn btn-lg btn-success btn-block">
        </form>
    </div>
    <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
