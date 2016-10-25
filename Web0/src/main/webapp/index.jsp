<%@ page import="model.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Boolean fail = (Boolean) request.getAttribute("fail");
    if (!fail) {
        out.print("Вы в великой лабуде");
        ArrayList<User> users = (ArrayList<User>) request.getAttribute("users");
        if (!users.isEmpty()) {
            out.print("<br>");
            out.print("<table border=\"2\">");
            out.print("<tr><td>id</td><td>login</td><td>password</td></tr>");
            for (User user : users) {
                out.print("<tr>");
                out.print("<td>" + user.getId() + "</td>" + "<td>" + user.getLogin() + "</td>" + "<td>" + user.getPassword() + "</td>");
                out.print("</tr>");
            }
            out.print("</table>");
        }
    }
    else {
        out.print("<p color=\"red\">Incorrect input. Try else.</p>");
    }
%>
</body>
</html>