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
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script>
        $(function () {
            $(".meun-item").click(function () {
                $(".meun-item").removeClass("meun-item-active");
                $(this).addClass("meun-item-active");
                var itmeObj = $(".meun-item").find("img");
                itmeObj.each(function () {
                    var items = $(this).attr("src");
                    items = items.replace("_grey.png", ".png");
                    items = items.replace(".png", "_grey.png")
                    $(this).attr("src", items);
                });
                var attrObj = $(this).find("img").attr("src");
                ;
                attrObj = attrObj.replace("_grey.png", ".png");
                $(this).find("img").attr("src", attrObj);
            });

            $(".toggle-btn").click(function () {
                $("#leftMeun").toggleClass("show");
                $("#rightContent").toggleClass("pd0px");
            })
        })

        function changeFrameHeight() {
            var ifm1 = document.getElementById("ifrbody1");
            ifm1.height = document.documentElement.clientHeight;
            ifm1.width = document.documentElement.clientWidth;
        }
    </script>

    <link href="../../css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../../css/common.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/slide.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/flat-ui.min.css"/>
    <link rel="stylesheet" type="text/css" href="../../css/jquery.nouislider.css">
</head>
<body>
<%--<h1>您好，欢迎<c:out value="${sessionScope.user.userName}"></c:out>登录系统！ </h1>--%>
<%--<br>--%>
<%--<div>您的部门是：<c:out value="${sessionScope.user.department}"></c:out></div>--%>

<div id="wrap">
    <!-- 左侧菜单栏目块 -->
    <div class="leftMeun" id="leftMeun">
        <div id="logoDiv">
            <p id="logoP"><img id="logo" alt="左右结构项目" src="../../images/logo.png"><span>人事工资查询系统</span></p>
        </div>
        <div id="personInfor">
            <p id="userName"><c:out value="${sessionScope.user.epName}"></c:out></p>
            <p><span><c:out value="${sessionScope.user.department}"></c:out></span></p>
            <p><span><c:out value="${sessionScope.user.phone}"></c:out></span></p>
            <p>
                <a>退出登录</a>
            </p>
        </div>
        <div class="meun-title">信息查询</div>
        <div class="meun-item meun-item-active" href="#PersonalInfo" aria-controls="PersonalInfo" role="tab"
             data-toggle="tab"><img src="../../images/icon_source.png">个人信息
        </div>
        <div class="meun-item" href="#QuerySalary" aria-controls="QuerySalary" role="tab" data-toggle="tab"><img
                src="../../images/icon_card.png">工资查询
        </div>
        <div class="meun-item" href="#upLoad" aria-controls="upLoad" role="tab" data-toggle="tab"><img
                src="../../images/icon_change_grey.png">工资表上传
        </div>
        <div class="meun-item" href="#Query" aria-controls="Query" role="tab" data-toggle="tab"><img
                src="../../images/icon_chara_grey.png">查询员工工资
        </div>
    </div>



    <!-- 右侧具体内容栏目 -->
    <div id="rightContent">
        <a class="toggle-btn" id="nimei">
            <i class="glyphicon glyphicon-align-justify"></i>
        </a>
        <!-- Tab panes -->
        <div class="tab-content">
            <!-- 个人信息 -->
            <div role="tabpanel" class="tab-pane active" id="PersonalInfo">
                个人信息
            </div>

            <!-- 工资查询 -->

            <div role="tabpanel" class="tab-pane" id="QuerySalary">
                <%--<jsp:include page="SelfSalaryInfo.jsp"></jsp:include>--%>
                <a href="/salarysys/getSelfSalaryPage" target="#ifrbody1">去查询</a>
                <%--<iframe id="ifrbody2" name="ifrbody2" src="http://localhost:8080/salarysys/getSelfSalaryPage" frameborder="0" onload="changeFrameHeight()" scrolling="no"></iframe>--%>
            </div>
            <!--工资表上传-->

            <div role="tabpanel" class="tab-pane" id="upLoad">
                <%--如果没有这个超链接，直接写在iframe的src,那么它会默认直接到文件夹下去找文件而不经过Spring mvc,就无法通过拦截器来拦截此请求，造成不安全的权限验证。linsong.wei 2018年12月8日--%>
                <div><a href="/salarysys/ToUpload" target="ifrbody1">上传Excel文件需要权限，请点击这里验证是否有权限上传。</a></div>
                <iframe id="ifrbody1" name="ifrbody1" frameborder="0" onload="changeFrameHeight()" scrolling="no"></iframe>
            </div>
            <!--查询员工工资-->

            <div role="tabpanel " class="tab-pane " id="Query ">
                <%--<iframe id="ifrbody2 " name="ifrbody2 " src="http://localhost:8080/salarysys/ToUpload"  scrolling="no" frameborder="no ">查询员工工资</iframe>--%>
            </div>

        </div>
    </div>



</div>
<script src="../../js/jquery.nouislider.js"></script>
<script>


    window.onload = function () {
        changeFrameHeight();
    }
    window.onresize = function () {
        changeFrameHeight();
    }
    function iframeLoad() {
        var ifm = document.getElementById("ifrbody1");

        ifm.height = document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;
    }
    function changeFrameHeight() {
        var ifm = document.getElementById("ifrbody1");
        ifm.height = document.documentElement.clientHeight;
        ifm.width = document.documentElement.clientWidth;

        var ifm2 = document.getElementById("ifrbody2");
        ifm2.height = document.documentElement.clientHeight;
        ifm2.width = document.documentElement.clientWidth;
    }
    window.onload = function () {
        changeFrameHeight();
    }
    window.onresize = function () {
        changeFrameHeight();
    }






</script>
</body>
</html>