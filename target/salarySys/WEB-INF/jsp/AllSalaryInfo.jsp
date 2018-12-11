<%--
  Created by IntelliJ IDEA.
  User: trcay
  Date: 2018/12/11
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>人员工资详细</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../../css/bootstrap.min.css">
    <script src="../../js/jquery-3.2.1.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../js/bootstrap_table/bootstrap-table.css">
    <script src="../../js/bootstrap_table/bootstrap-table.js"></script>
    <script src="../../js/bootstrap_table/bootstrap-table-zh-CN.js"></script>

</head>
<body>
<div>
    <%--加一个样式兼容Firefox和chrome让表格数据不换行--%>
    <table id="SelfSalaryTB" style="word-break: keep-all;white-space:nowrap"></table>
</div>
<script>


    $(function () {

        //1.初始化Table
        var oTable = new TableInit();
        oTable.Init();

        //2.初始化Button的点击事件
        var oButtonInit = new ButtonInit();
        oButtonInit.Init();

    });


    var TableInit = function () {
        var oTableInit = new Object();
        //初始化Table
        oTableInit.Init = function () {
            $('#SelfSalaryTB').bootstrapTable({
                url: '/salarysys/getAllSalary',         //请求后台的URL（*）
                method: 'get',                      //请求方式（*）
//                toolbar: '#toolbar',                //工具按钮用哪个容器
                striped: true,                      //是否显示行间隔色
                cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
                pagination: true,                   //是否显示分页（*）
                sortable: false,                     //是否启用排序
                sortOrder: "asc",                   //排序方式
                queryParams: oTableInit.queryParams,//传递参数（*）
                sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
                pageNumber: 1,                       //初始化加载第一页，默认第一页
                pageSize: 10,                       //每页的记录行数（*）
                pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
                search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
                strictSearch: true,
                showColumns: true,                  //是否显示所有的列
                showRefresh: true,                  //是否显示刷新按钮
                minimumCountColumns: 2,             //最少允许的列数
                clickToSelect: true,                //是否启用点击选中行
                height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
                uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
                showToggle: true,                    //是否显示详细视图和列表视图的切换按钮
                cardView: false,                    //是否显示详细视图
                detailView: false,                   //是否显示父子表
                columns: [{
                    checkbox: true
                }, {
                    field: 'date',
                    title: '发放日期',
                }, {
                    field: 'month',
                    title: '月份'
                }, {
                    field: 'epName',
                    title: '姓名'
                }, {
                    field: 'position',
                    title: '岗位工资'
                }, {
                    field: 'annual',
                    title: '年功津贴'
                }, {
                    field: 'global',
                    title: '综合补贴'
                }, {
                    field: 'profession',
                    title: '专业人才津贴'
                }, {
                    field: 'overtime',
                    title: '加班工资'
                }, {
                    field: 'welfare',
                    title: '福利费'
                },{
                    field: 'special',
                    title: '专项奖'
                }, {
                    field: 'special1',
                    title: '专项奖预留1'
                },{
                    field: 'special2',
                    title: '专项奖预留2'
                },{
                    field: 'otherWelfare',
                    title: '其他福利'
                },{
                    field: 'monthlyPerformance',
                    title: '月度绩效'
                },{
                    field: 'shouldPay',
                    title: '应发合计'
                },{
                    field: 'pensionD',
                    title: '基本养老保险（个人扣款）'
                },{
                    field: 'pensionC',
                    title: '基本养老保险（个人补缴）'
                },{
                    field: 'idlenessD',
                    title: '失业保险（个人扣款）'
                },{
                    field: 'idlenessC',
                    title: '失业保险（个人补缴）'
                },{
                    field: 'medicalD',
                    title: '基本医疗保险（个人扣款）'
                },{
                    field: 'enterpriseAnnuity',
                    title: '企业年金（个人扣款）'
                },{
                    field: 'housing',
                    title: '住房公积金（个人扣款）'
                },{
                    field: 'withholdOther',
                    title: '代扣其他扣款项'
                },{
                    field: 'withholdWE',
                    title: '代扣水电费'
                },{
                    field: 'withholdRent',
                    title: '代扣房租费'
                },{
                    field: 'withholdUnion',
                    title: '代扣工会费'
                },{
                    field: 'withholdTrash',
                    title: '代扣垃圾处理费'
                },{
                    field: 'tax',
                    title: '本次扣税'
                },{
                    field: 'withholdTotal',
                    title: '扣款合计'
                },{
                    field: 'realTotal',
                    title: '实发合计'
                },{
                    field: 'last',
                    title: '上次未扣'
                },{
                    field: 'thisD',
                    title: '本次未扣'
                },{
                    field: 'taxRefund',
                    title: '个税补退补缴'
                },{
                    field: 'taxBase',
                    title: '本次扣税基数'
                },]
            });
        };

        //得到查询的参数
        oTableInit.queryParams = function (params) {
            var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
                limit: params.limit,   //页面大小
                offset: params.offset  //页码

            };
            return temp;
        };
        return oTableInit;
    };


    var ButtonInit = function () {
        var oInit = new Object();
        var postdata = {};

        oInit.Init = function () {
            //初始化页面上面的按钮事件
        };

        return oInit;
    };


</script>

</body>
</html>

