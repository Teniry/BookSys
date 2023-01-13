<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="../../static/script/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="../../static/css/controlReq.css">
    <base href="http://localhost:8080/bookSystem/">
</head>
<body>

<div style="width: 100%;height: 100px">
    <div style="padding-left:545px;padding-top: 58px;font-size: 30px">
     <span>
        <b> 挂失记录</b>
     </span>
    </div>
</div>

<div id="main">
<table>
    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>邮箱</td>
        <td>状态</td>
        <td>操作</td>


    </tr>
    <c:forEach items="${sessionScope.w_reader}" var="reader">
        <tr>
            <td>${reader.rdID}</td>
            <td>${reader.rdName}</td>
            <td>${reader.rdEmail}</td>
            <td>${reader.rdStatus}</td>
            <td>
                <button class="concel_loss"   rdID="${reader.rdID}" id="reject">取消挂失</button>
            </td>
        </tr>
        </div>
    </c:forEach>
</table>
</div>
</body>

<script type="text/javascript">

    $(function (){

        $(".concel_loss").click(function (){
            var id=$(this).attr("rdID");
            var obj=confirm("您确定要取消挂失吗?");
            if(obj){
                $.ajax({
                    url:"http://localhost:8080/bookSystem/managerServlet",
                    error: function () {
                        alert("请求失败");
                    },
                    success: function (data) {
                        alert(data.cancel);
                        window.location.reload();
                    },
                    type: "POST",
                    dataType: "json",
                    data: {
                        action: "cancelLoss",
                        id: id
                    },

                });
            }

        });

    });
</script>

</html>