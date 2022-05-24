<%--
  Created by IntelliJ IDEA.
  User: Animal
  Date: 2022/5/16
  Time: 9:39
  To change this template use File | Settings | File Templates.
--%>
<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <base href=<%=basePath%>>
    <title>Title</title>
    <script src="jquery/jquery-1.11.1-min.js"></script>
    <script>
        $(function () {
                document.location.href = "jsp/login.jsp"
        })
    </script>
</head>
<body>
<%--    请输入搜索关键字:<input type="text">--%>
<%--    <button id="query">搜索</button>--%>
</body>
</html>
