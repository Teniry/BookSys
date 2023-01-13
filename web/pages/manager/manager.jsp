<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>管理界面</title>

    <link rel="stylesheet" type="text/css" href="../../static/css/manager.css">
    <script type="text/javascript" src="../../static/script/jquery-3.5.1.js"></script>

    <script type="text/javascript">

        setTimeout(function (){
            if(document.all){
                document.getElementById("bookManerger").click();
            }else{
                var e = document.createEvent("MouseEvents");
                e.initEvent("click", true, true);
                document.getElementById("bookManerger").dispatchEvent(e);
            }
        },0);

        function controlBook(){
            var ifr=document.getElementById("ifr");
            ifr.src="controlBook.jsp";
        }

        function  controlReq(){
            var ifr=document.getElementById("ifr");
            ifr.src="controlReq.jsp"
        }

        function  controlLoss(){
            var ifr=document.getElementById("ifr");
            ifr.src="controlLoss.jsp"
        }

        function controlexit(){
            window.location.href="../rd/login_success.jsp";
        }
    </script>


    <style>
        iframe{
            float: left;
            height: 669px;
            width: calc(100% - 254px);
            background: #39987c;
        }
    </style>

</head>
<body style="margin: 0">

   <div class="m_header">

     <div class="header_font" style="margin-left: 80px">
        <h2 style="margin: 0;font-family: 宋体">欢迎登陆 &nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;后台管理系统</h2>
     </div>




</div>

<div class="m_content">

    <div class="m_left" >

       <div class="m_left_item">
           <div>

               <img class="character"  alt="" src="../../static/img/default.jpg">
           </div>

           <div style="text-align: center;padding-top: 135px">
               <p style="margin: 0;color: white">${reader.rdName}</p>
           </div>

           <div class="m_item" id="bookManerger" style="margin-top: 20px" onclick="controlBook()">
               <p>图书管理</p>
           </div>

           <div class="m_item"  onclick="controlReq()" >
               <p>注册申请</p>
           </div>

           <div class="m_item" onclick="controlLoss()" >
               <p>挂失记录</p>
           </div>

           <div class="m_item"  onclick="controlexit()" >
               <p>返回</p>
           </div>


   </div>


</div>

  <iframe src="" name="ifr" id="ifr">
  </iframe>

</div>

</body>


</html>