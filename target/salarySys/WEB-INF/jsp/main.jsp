<%--
  Created by IntelliJ IDEA.
  User: trcay
  Date: 2018/12/5
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
        <meta charset="UTF-8">
        <title>工资管理系统</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../../css/bootstrap.min.css">
        <script src="../../js/jquery-3.2.1.min.js"></script>
        <script src="../../js/bootstrap.min.js"></script>
    </head>
<body>
<h1>您好，欢迎<c:out value="${sessionScope.user.userName}"></c:out>登录系统！ </h1>
<br>
<div>您的部门是：<c:out value="${sessionScope.user.department}"></c:out></div>
</body>
</html>