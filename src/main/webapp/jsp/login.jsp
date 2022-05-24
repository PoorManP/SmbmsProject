<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%
    String basePath = request.getScheme() + "://" +
            request.getServerName() + ":" + request.getServerPort() +
            request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head lang="en">
    <base href="<%=basePath%>">
    <meta charset="UTF-8">
    <title>系统登录 - 超市订单管理系统</title>
    <link type="text/css" rel="stylesheet" href="statics/css/style.css"/>
    <script src="jquery/jquery-1.11.1-min.js"></script>
    <script type="text/javascript">
        /* if(top.location!=self.location){
              top.location=self.location;
         } */

        $(function () {


            $("#login").click(function () {
                login();
            })
        })

        function login() {
            if ($.trim($("#userCode").val() == "") || $("#userPassword").val() == "") {
                alert("账号或者密码不能为空")
                return false
            }
            $.ajax({
                type: "post",
                url: "login",
                dataType: "json",
                data: {
                    "userCode": $.trim($("#userCode").val()),
                    "userPassword": $.trim($("#userPassword").val())
                },
                success: function (response) {
                    if (response.success) {
                        document.location.href = "jsp/frame.jsp"
                    } else {
                        $("#msg").text(response.msg)
                    }
                }
            })
        }
    </script>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>超市订单管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" name="actionForm" id="actionForm" method="post">
            <div class="info" id="msg"></div>
            <div class="inputbox">
                <label for="userCode">用户名：</label>
                <input type="text" class="input-text" id="userCode" name="userCode" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label for="userPassword">密码：</label>
                <input type="password" id="userPassword" name="userPassword" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input type="button" value="登录" id="login"/>
                <input type="reset" value="重置"/>
            </div>
        </form>
    </section>
</section>
</body>
</html>
