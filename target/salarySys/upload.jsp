<%--
  Created by IntelliJ IDEA.
  User: trcay
  Date: 2018/12/6
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>上传文件</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<form enctype="multipart/form-data" id="batchUpload"  action="salarysys/upload" method="post" class="form-horizontal">
    <button class="btn btn-success btn-xs" id="uploadEventBtn" style="height:26px;"  type="button" >选择文件</button>
    <input type="file" name="file"  style="width:0px;height:0px;" id="uploadEventFile">
    <input id="uploadEventPath"  disabled="disabled"  type="text" >
</form>
<button type="button" class="btn btn-success btn-sm"  onclick="user.uploadBtn()" >上传</button>
<script>


    var User = function(){
        this.init = function(){
            //模拟上传excel
            $("#uploadEventBtn").unbind("click").bind("click",function(){
                $("#uploadEventFile").click();
            });
            $("#uploadEventFile").bind("change",function(){
                $("#uploadEventPath").attr("value",$("#uploadEventFile").val());
            });
        };
        //点击上传按钮
        this.uploadBtn = function(){
            var uploadEventFile = $("#uploadEventFile").val();
            if(uploadEventFile == ''){
                alert("请选择excel,再上传");
            }else if(uploadEventFile.lastIndexOf(".xls")<0){//可判断以.xls和.xlsx结尾的excel
                alert("只能上传Excel文件");
            }else{
                var url =  '/salarysys/upload';
                var formData = new FormData($('form')[0]);
                user.sendAjaxRequest(url,'POST',formData);
            }
        };
        this.sendAjaxRequest = function(url,type,data){
            $.ajax({
                url : url,
                type : type,
                data : data,
                success : function(result) {
                    alert( result);
                },
                error : function() {
                    alert( "excel上传失败");
                },
                cache : false,
                contentType : false,
                processData : false
            });
        };
    }
    var user;
    $(function(){
        user = new User();
        user.init();
    });
</script>
</body>
</html>
