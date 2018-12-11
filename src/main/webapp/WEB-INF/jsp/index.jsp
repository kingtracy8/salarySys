<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>salarySys</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../js/jquery.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <style>
        #from {
            /*background-color: #96b97d;*/
        }

        .mycenter {
            margin-top: 150px;
            margin-left: auto;
            margin-right: auto;
            height: 350px;
            width: 500px;
            padding: 3%;
            padding-left: 5%;
            padding-right: 5%;
            border: 1.5px solid #dcdcdc;
        }

        .mycenter mysign {
            width: 440px;
        }

        .mycenter input,
        checkbox,
        button {
            margin-top: 2%;
            margin-left: 10%;
            margin-right: 10%;
        }

        .mycheckbox {
            margin-top: 10px;
            margin-left: 40px;
            margin-bottom: 10px;
            height: 10px;
        }
    </style>
</head>
<body>
<form id="from" action="/salarysys/login" method="post">
    <div class="mycenter">
        <div class="mysign">
            <div class="col-lg-11 text-center text-info">
                <h2>请登录</h2>
            </div>
            <div class="col-lg-10">
                <input type="text" class="form-control" name="username" placeholder="请输入账户名" required autofocus/>
            </div>
            <div class="col-lg-10">
            </div>
            <div class="col-lg-10" style="margin-top: 5px;">
                <input type="password" class="form-control" name="password" placeholder="请输入密码" required autofocus/>
            </div>
            <div class="col-lg-10">
            </div>
            <div class="col-lg-10 mycheckbox checkbox">
                <input type="checkbox" class="col-lg-1">记住密码</input>
            </div>
            <div class="col-lg-10">
            </div>
            <div class="col-lg-10" style="margin-top: 5px;">
                <button type="submit" id="btn" class="btn btn-success col-lg-12">
                    登录
                </button>
            </div>
        </div>
    </div>
</form>

</body>
</html>
