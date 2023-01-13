<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
<head>
    <meta charset="UTF-8">
    <title>login_success</title>
        <link rel="stylesheet" type="text/css" href="../../static/css/login_Success.css">
    <script type="text/javascript" src="../../static/script/jquery-3.5.1.js"></script>

    <base href="http://localhost:8080/bookSystem/">

    <script type="text/javascript">
        $(function (){
            // $("button.addToLend").click(function (){
            //     var lend=$(this).attr("lendcount");
            //     var can=$(this).attr("canlend");
            //     if(lend+1>=can){
            //         return  confirm("您已超出借书数额！");
            //     }
            //     var bookId=$(this).attr("bookID");
            //     location.href="http://localhost:8080/bookSystem/lendServlet?action=addItem&id="+bookId;
            //
            // });
            //借书
            $("button.addToLend").click(function (){
                var bookId=$(this).attr("bookID");
                $.ajax({
                    url:"http://localhost:8080/bookSystem/lendServlet",
                    async:true,
                    error:function (){
                        alert("ERROR","请求失败");
                    },
                    success:function (data){
                        if(data.msg==1){
                            alert("借书成功！");
                        }else{
                            alert("您已超出数额!")
                        }
                        window.location.reload(); //刷新页面
                    },
                    type:"POST",
                    dataType:"json",
                    data:{
                        action:"ajaxAdd",
                        id: bookId
                    }
                });
            });

           //还书
            $(".deleteItem").click(function (){
                //获取商品名
                var name=$(this).parent().parent().find("td:first").text();
                var id=$(this).attr("bkid");
                var obj=confirm("您确定归还"+name+"吗？");
                if(obj) {
                    $.ajax({
                        url: "http://localhost:8080/bookSystem/lendServlet",
                        async: true,
                        error: function () {
                            alert("请求失败");
                        },
                        success: function (data) {
                            window.location.reload();

                        },
                        type: "POST",
                        dataType: "json",
                        data: {
                            action: "ajaxDelete",
                            id: id
                        }
                    });
                }
            });

            //挂失
            $("#loss").click(function (){
                var obj=confirm("您确定要挂失吗？");
                if(obj){
                    $.ajax({
                        url:"http://localhost:8080/bookSystem/cerServlet",
                        error: function () {
                            alert("请求失败");
                        },
                        success: function (data) {
                            window.location.reload();
                        },
                        type: "POST",
                        dataType: "json",
                        data: {
                            action: "ajaxLoss"
                        },
                    });
                }

            });

            //注销
            $("#withdraw").click(function (){
                var obj=confirm("您确定要注销吗？");
                if(obj) {
                    $.ajax({
                        url: "http://localhost:8080/bookSystem/cerServlet",
                        error: function () {
                            alert("请求失败");
                        },
                        success: function (data) {
                            if(data.withdraw=="t"){
                                window.location.href="http://localhost:8080/bookSystem/";
                            }else{
                                alert(data.withdraw);
                            }
                        },
                        type: "POST",
                        dataType: "json",
                        data: {
                            action: "ajaxWithdraw"
                        },
                    });
                }
            });

        });


    </script>

    <script>
        function showBook(){

            document.getElementById("showBook").style.display="block";
            document.getElementById("showLend").style.display="none";
            document.getElementById("showCer").style.display="none";
            document.getElementById("modify").style.display="none";

        }
        function showLend(){
            document.getElementById("showBook").style.display="none";
            document.getElementById("showLend").style.display="block";
            document.getElementById("showCer").style.display="none";
            document.getElementById("modify").style.display="none";
        }
        function showCer(){
            document.getElementById("showBook").style.display="none";
            document.getElementById("showLend").style.display="none";
            document.getElementById("showCer").style.display="block";
            document.getElementById("modify").style.display="none";
        }
        function modify(){
            document.getElementById("showBook").style.display="none";
            document.getElementById("showLend").style.display="none";
            document.getElementById("showCer").style.display="none";
            document.getElementById("modify").style.display="block";
        }
    </script>


    <style type="text/css">
        .login_form{
            align-content: center;

            border: 1px solid black;
             margin-left: 456px;
            height: 350px;
            width: 350px;
        }
      .box:active{
          color: red;
      }
    </style>
</head>




        <div class="header" style="height: 90px;width: 100%">
        <img class="logo_img"  style="position: absolute;left: 0; height: 80px;opacity: 0.9;" alt="" src="static/img/changjiang.jpg" >
        <h2 style="color: black;font-family: 宋体;font-size: 35px;padding-top: 15px;margin-left: 730px"><b>图书管理系统</b></h2>
         
         <c:if test="${sessionScope.reader.rdType>=1}">

            <a href="pages/manager/manager.jsp" style="text-decoration-line: none"><h3 style="color: red;margin-left: 1400px;padding-top: 33px">后台管理</h3></a>
         </c:if>
        </div>

       <div class="cotent">

           <div id="item">
               <div class="boxHeader">
                       <div class="banner">


                           <img class="character" alt="" src="static/img/default.jpg">

                           <div class="login_Inf" >
                               <br>
                               <p>${sessionScope.rdID}</p>
                           </div>
                           <div class="login_Inf">
                               <br>
                               <p>${sessionScope.reader.rdName}</p>
                           </div>
                           <div class="login_exit">
                               <br>
                               <a  id="log" onclick="logout()"  href="readerServlet?action=logout" >退出登录</a>
                           </div>
                       </div>
               </div>
               <div class="box"  onclick="showBook()">
                  <div class="a_box" >
                   <a class="box_text" >图书</a>
                  </div>
               </div>
               <div class="box" onclick="showLend()" >
                    <div class="a_box">

                        <a class="box_text" >借阅</a>
                    </div>
               </div>
               <div class="box" onclick="showCer()">
                   <div class="a_box">

                       <a class="box_text"  >借书证</a>
                   </div>
               </div>
               <div class="box" onclick="modify()">
                   <div class="a_box">

                       <a class="box_text"  >修改密码</a>
                   </div>
               </div>

           </div>
           <div id="midium">
               <div id="showBook">
                   <div class="main">
                       <div id="book">
                           <div class="book_cond">
                               <form action="pageServlet" method="get">
                                   <input type="hidden" name="action" value="pageByBook">
                                   图书名称：<input id="bkName" type="text" name="bkName" value="${param.bkName}">
                                   图书编号：<input id="bkISBN" type="text" name="bkISBN" value="${param.bkISBN}">
                                   <input type="submit" value="查询" />
                               </form>
                           </div>
                           <div style="text-align: center">
                           </div>

                           <c:if test="${not empty sessionScope.bkpage.items}">
                               <c:forEach items="${sessionScope.bkpage.items}" var="book">
                                   <div class="b_list">
                                       <div class="img_div">
                                           <img class="book_img" alt="" src="static/img/gai.png" />
                                       </div>
                                       <div class="book_info">
                                           <div class="book_name">
                                               <span class="sp1">书名:</span>
                                               <span class="sp2">《${book.bkName}》</span>
                                           </div>
                                           <div class="book_author">
                                               <span class="sp1">作者:</span>
                                               <span class="sp2">${book.bkAuthor}</span>
                                           </div>
                                           <div class="book_press">
                                               <span class="sp1">出版社:</span>
                                               <span class="sp2">${book.bkPress}</span>
                                           </div>
                                           <div class="book_price">
                                               <span class="sp1">价格:</span>
                                               <span class="sp2">${book.bkPrice}</span>
                                           </div>
                                           <div class="book_ISBN">
                                               <span class="sp1">ISBN:</span>
                                               <span class="sp2">${book.bkISBN}</span>
                                           </div>
                                           <div class="book_brief">
                                               <span class="sp1">简介:</span>
                                               <span class="sp2">${book.bkBrief}</span>
                                           </div>

                                       </div>
                                       <div class="book_status">
                                           <span class="sp1">状态:</span>
                                           <span class="sp2">${book.bkStatus}</span>
                                       </div>
                                       <div class="book_add">
                                           <button bookID="${book.bkID}" class="addToLend">借书</button>
                                       </div>
                                   </div>
                               </c:forEach>
                           </c:if>

                           <c:if test="${empty sessionScope.bkpage.items}">
                           <c:forEach items="${sessionScope.page.items}" var="book">
                           <div class="b_list">
                               <div class="img_div">
                                  <img class="book_img" alt="" src="static/img/gai.png" />
                               </div>

                               <div class="book_info">
                                   <div class="book_name">
                                       <span class="sp1">书名:</span>
                                       <span class="sp2">《${book.bkName}》</span>
                                   </div>
                                   <div class="book_author">
                                       <span class="sp1">作者:</span>
                                       <span class="sp2">${book.bkAuthor}</span>
                                   </div>
                                   <div class="book_press">
                                       <span class="sp1">出版社:</span>
                                       <span class="sp2">${book.bkPress}</span>
                                   </div>
                                   <div class="book_price">
                                       <span class="sp1">价格:</span>
                                       <span class="sp2">${book.bkPrice}</span>
                                   </div>
                                   <div class="book_ISBN">
                                       <span class="sp1">ISBN:</span>
                                       <span class="sp2">${book.bkISBN}</span>
                                   </div>
                                   <div class="book_brief">
                                       <span class="sp1">简介:</span>
                                       <span class="sp2">${book.bkBrief}</span>
                                   </div>

                               </div>
                               <c:if test="${book.bkStatus=='在馆'}">
                               <div class="book_status">
                                   <span class="sp1">状态:</span>
                                   <span class="sp2" style="color: #13f317">${book.bkStatus}</span>
                               </div>
                               </c:if>
                               <c:if test="${book.bkStatus!='在馆'}">
                               <div class="book_status">
                               <span class="sp1">状态:</span>
                               <span class="sp2" style="color: #ec1e0a">${book.bkStatus}</span>
                           </div>
                               </c:if>

                               <c:if test="${sessionScope.reader.rdStatus!='挂失'}">
                               <c:if test="${book.bkStatus=='在馆'}">
                               <div class="book_add">
                                   <button bookID="${book.bkID}" class="addToLend" >借书</button>
                               </div>
                               </c:if>
                               <c:if test="${book.bkStatus!='在馆'}">
                                   <div class="book_add">
                                       <button bookID="${book.bkID}" lendcount="${sessionScope.reader.rdBorrow}" canlend="${sessionScope.readerType.canLendCount}" class="addToLend" disabled="disabled">已借出</button>
                                   </div>
                               </c:if>
                               </c:if>

                               <c:if test="${sessionScope.reader.rdStatus=='挂失'}">
                                   <div class="book_add">
                                       <button bookID="${book.bkID}" lendcount="${sessionScope.reader.rdBorrow}" canlend="${sessionScope.readerType.canLendCount}" class="addToLend" disabled="disabled">在馆</button>
                                   </div>
                               </c:if>

                           </div>
                           </c:forEach>
                           </c:if>
                       </div>


                       <c:if test="${not empty sessionScope.bkpage.items}">
                           <div id="page_nav">
                               <c:if test="${sessionScope.bkpage.pageNo>1}">

                                   <a href="${sessionScope.bkpage.url}&pageNo=1">首页</a>
                                   <a href="${sessionScope.bkpage.url}&pageNo=${sessionScope.bkpage.pageNo-1}">上一页</a>
                               </c:if>

                                   <%--  页码输出的开始--%>
                               <c:choose>
                                   <%--情况1：如果页码小于等于5--%>
                                   <c:when test="${sessionScope.bkpage.pageTotal<=5}">
                                       <c:forEach begin="1" end="${sessionScope.bkpage.pageTotal}" var="i">
                                           <c:if test="${i==sessionScope.bkpage.pageNo}">
                                               [${i}]
                                           </c:if>
                                           <c:if test="${i!=sessionScope.bkpage.pageNo}">
                                               <a href="${sessionScope.bkpage.url}&pageNo=${i}">${i}</a>
                                           </c:if>

                                       </c:forEach>
                                   </c:when>

                               </c:choose>


                               <c:if test="${sessionScope.bkpage.pageNo<sessionScope.bkpage.pageTotal}">

                                   <a href="${sessionScope.bkpage.url}&pageNo=${sessionScope.bkpage.pageNo+1}">下一页</a>
                                   <a href="${sessionScope.bkpage.url}&pageNo=${sessionScope.bkpage.pageTotal}">末页</a>
                               </c:if>
                               共${sessionScope.bkpage.pageTotal}页，${sessionScope.bkpage.pageTotalCount}条记录

                           </div>
                       </c:if>

                       <c:if test="${empty sessionScope.bkpage.items}">

                       <div id="page_nav">
                           <c:if test="${sessionScope.page.pageNo>1}">

                               <a href="${sessionScope.page.url}&pageNo=1">首页</a>
                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageNo-1}">上一页</a>
                           </c:if>

                           <%--  页码输出的开始--%>
                           <c:choose>
                               <%--情况1：如果页码小于等于5--%>
                               <c:when test="${sessionScope.page.pageTotal<=5}">
                                   <c:forEach begin="1" end="${sessionScope.page.pageTotal}" var="i">
                                       <c:if test="${i==sessionScope.page.pageNo}">
                                           [${i}]
                                       </c:if>
                                       <c:if test="${i!=sessionScope.page.pageNo}">
                                           <a href="${sessionScope.page.url}&pageNo=${i}">${i}</a>
                                       </c:if>

                                   </c:forEach>
                               </c:when>

                               <c:when test="${sessionScope.page.pageTotal>5}">
                                   <c:choose>
                                       <c:when test="${sessionScope.page.pageNo<=3}">
                                           <c:forEach begin="1" end="5" var="i">
                                               <c:if test="${i==sessionScope.page.pageNo}">
                                                   [${i}]
                                               </c:if>
                                               <c:if test="${i!=sessionScope.page.pageNo}">
                                                   <a href="${sessionScope.page.url}&pageNo=${i}">${i}</a>
                                               </c:if>

                                           </c:forEach>
                                       </c:when>

                                       <c:when test="${sessionScope.page.pageNo>sessionScope.page.pageTotal-3}">
                                           <c:forEach begin="${sessionScope.page.pageTotal-4}" end="${sessionScope.page.pageTotal}" var="i">
                                               <c:if test="${i==sessionScope.page.pageNo}">v
                                                   [${i}]
                                               </c:if>
                                               <c:if test="${i!=sessionScope.page.pageNo}">
                                                   <a href="${sessionScope.page.url}&pageNo=${i}">${i}</a>
                                               </c:if>

                                           </c:forEach>
                                       </c:when>
                                       <c:otherwise>
                                           <c:forEach begin="${sessionScope.page.pageNo-2}" end="${sessionScope.page.pageNo+2

							}" var="i">
                                               <c:if test="${i==sessionScope.page.pageNo}">
                                                   [${i}]
                                               </c:if>
                                               <c:if test="${i!=sessionScope.page.pageNo}">
                                                   <a href="${sessionScope.page.url}&pageNo=${i}">${i}</a>
                                               </c:if>

                                           </c:forEach>
                                       </c:otherwise>
                                   </c:choose>

                               </c:when>

                           </c:choose>


                           <c:if test="${sessionScope.page.pageNo<sessionScope.page.pageTotal}">

                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageNo+1}">下一页</a>
                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageTotal}">末页</a>
                           </c:if>
                           共${sessionScope.page.pageTotal}页，${sessionScope.page.pageTotalCount}条记录
                       </div>
                       </c:if>
                   </div>

               </div>

               <div id="showLend" style="display: none">

                 <div id="main">
                     <table>
                         <tr>
                             <td>图书名称</td>
                             <td>单价</td>
                             <td>借阅日期</td>
                             <td>可借天数</td>
                             <td>操作</td>
                         </tr>

                         <c:if test="${empty sessionScope.lendcart}">
                             <tr>
                                 <td colspan="5"><a href="pages/rd/login_success.jsp" style="text-decoration-line: none;color: red">您还没有借书</a> </td>

                             </tr>
                         </c:if>
                         <c:if test="${ not empty sessionScope.lendcart}">

                         <c:forEach items="${sessionScope.lendcart}" var="book">

                         <tr>
                             <td>《${book.bkName}》</td>
                             <td>${book.bkPrice}</td>
                             <td>${sessionScope.lendDate}</td>
                             <td>${sessionScope.readerType.canLendDay}</td>

                             <c:if test="${sessionScope.reader.rdStatus!='挂失'}">
                             <td><button class="deleteItem"   bkid="${book.bkID}" style="background: red;height: 30px;width: 45px;border: none;color: white;size: 30px;border-radius:8px">还书</button></td>
                             </c:if>
                             <c:if test="${sessionScope.reader.rdStatus=='挂失'}">
                                 <td><button class="deleteItem"   bkid="${book.bkID}" disabled="disabled" style="background: red;height: 30px;width: 45px;border: none;color: white;size: 30px;border-radius:8px">还书</button></td>
                             </c:if>

                         </tr>
                         </c:forEach>
                         </c:if>
                     </table>
                     <c:if test="${ not empty sessionScope.lendcart}">
                         <div class="lend_info">
                             <span class="lend_span">已借数量 <span class="b_price">${sessionScope.reader.rdBorrow}</span>本</span>
                             <span class="lend_span">可借数量<span class="b_price">${sessionScope.readerType.canLendCount}</span>本</span>
                         </div>
                     </c:if>
                 </div>
               </div>
               <div id="showCer" style="display: none">
                   <div class="main">
                          <span>
                             </span>
                   <div class="cer">
                       <div class="login_cer">
                           <div class="form">
                               <span style="color: black;font-family: 微软雅黑体;font-size: 30px;margin-left: 120px" >借书证</span>
                               <div class="tit">
                                   <span class="errorMsg" >
                                       <!--									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>-->
								</span>
                               </div>

                                   <img style="width: 110px;height: 110px;margin-left: 100px;border-radius:90px " alt="" src="static/img/default.jpg">
                                   <br>
                                   <input type="hidden" name="action" value="regist" autocomplete="off" tabindex="1" name="" >
                                   <label class="login_lab">姓名：</label>
                                  <span  class="cer_information">${sessionScope.reader.rdName}</span>
                                   <br>
                                   <label class="login_lab">借书号:</label>
                                   <span class="cer_information">${sessionScope.reader.rdID}</span>
                                   <br>
                                   <label class="login_lab">类型：</label>
                                   <span class="cer_information">${sessionScope.readerType.rdTypeName}</span>
                                   <br>
                                   <label class="login_lab">部门：</label>
                                   <span class="cer_information">${sessionScope.reader.rdDept}</span>
                                    <br>
                                   <label class="login_lab">手机号：</label>
                                   <span class="cer_information">${sessionScope.reader.rdPhone}</span>
                                   <br>
                                   <label class="login_lab">邮箱：</label>
                                   <span class="cer_information">${sessionScope.reader.rdEmail}</span>
                                   <br>
                                   <label class="login_lab">办理时间：</label>
                                   <span class="cer_information">${sessionScope.reader.rdDateReg}</span>
                                   <br>
                                   <label class="login_lab">有效期至：</label>
                                   <span class="cer_information">${sessionScope.readerType.dateValid}</span>
                                   <br>
                                   <label class="login_lab">状态：</label>
                                   <span class="cer_information" >${sessionScope.reader.rdStatus}</span>
                                   <br>
                                   <c:if test="${sessionScope.reader.rdStatus=='有效'}">
                                   <button class="certificate_btn" id="loss" style="border-radius: 5px;border: none">挂失</button>
                                   </c:if>
                                   <c:if test="${sessionScope.reader.rdStatus!='有效'}">
                                       <button class="certificate_btn" id="loss" style="color: white;background: red;border-radius: 5px;border:none" disabled="disabled">已挂失</button>
                                   </c:if>


                                   <button class="certificate_btn" id="withdraw" style="border-radius: 5px;border: none">注销</button>

                           </div>
                       </div>
                   </div>

                   </div>

               </div>
               <div id="modify" style="display: none">
                   <div class="main">
                       <br>
                       <br>
                   <span style="color: black;font-family: 宋体;font-size: 40px;margin-left: 550px;margin-top: 30px" >密码修改</span>
                       <br>
                       <br>
                   <div class="login_form">
                       <div class="login_box">
                           <div class="form">
                               <div class="tit">
                                   <span class="errorMsg" id="errorMsg" >

								<%=request.getSession().getAttribute("login_msg")==null?"请输入密码":request.getSession().getAttribute("login_msg")%>
								</span>
                               </div>
                               <form action="readerServlet"  method="post">
                                   <input type="hidden" name ="action" value="modify">
                                   <br>
                                   <input type="hidden" name="action" value="modify">
                                   <br>
                                   <label>原密码：</label>
                                   <input class="itxt" type="text" placeholder="请输入原密码" autocomplete="off" tabindex="1" name="rdPwd" id="rdPwd"/>
                                   <br >
                                   <label>新密码：</label>
                                   <input class="itxt" type="password" placeholder="请输入新密码" autocomplete="off" tabindex="1" name="password" id="password" />
                                   <br >
                                   <label>确认密码：</label>
                                   <input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="rePwd" id="rePwd" />
                                   <br >
                                   <input type="submit" value="确定" onclick="msg()"  id="sub_btn" />
                               </form>
                           </div>
                       </div>
                       </div>
                   </div>

               </div>
           </div>
           </div>
           <div id="botto">
		<span>
			https://yangtzeu.libraryManager.com
		</span>
           </div>

</body>


  <script type="text/javascript">


    $(function (){
        $("#log").click(function (){
            return confirm("你确定退出吗？");
        });
    });


    function msg(){
        var rdPwd=$("#rdPwd").val();
        var password=$("#password").val();
        var rePwd=$("#rePwd").val();
        if(rdPwd==password){
            alert("新密码不能与旧密码相等");
        }else{
            if(password==rePwd){
                alert("密码修改成功,请重新登录!");
            }else{
                alert("两次输入的密码不同");
            }
        }
    }
  </script>
</html>