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
            $("button.addToLend").click(function (){

                var bookId=$(this).attr("bookID")
                location.href="http://localhost:8080/bookSystem/lendServlet?action=addItem&id="+bookId;
                alert(bookId);
                // $.getJSON("http://localhost:8080/book/cartSevlet","action=ajaxAdd&id="+bookId,function (data){
                //
                // })
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
    </style>
</head>
<body>
${sessionScope.cart}

        <div class="header" style="height: 80px;width: 100%">
        <img class="logo_img"  style="position: absolute;left: 0; height: 80px;opacity: 0.9;" alt="" src="static/img/changjiang.jpg" >

        <!--<span id="heaedr_content" style="font-size: 40px;color: black;font-family:??????;padding-top: 50px" >??????????????????</span>-->
        <h2 style="color: black;font-family: ??????;font-size: 35px;padding-top: 15px;margin-left: 730px"><b>??????????????????</b></h2>
        </div>
       <div class="cotent">
           <div id="item">
               <div class="boxHeader">
                       <div class="banner">


                           <!--<span id="heaedr_content" style="font-size: 40px;color: black;font-family:??????;padding-top: 50px" >??????????????????</span>-->
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
                               <a  id="log" onclick="logout()"  href="readerServlet?action=logout" >????????????</a>
                           </div>
                       </div>
               </div>
               <div class="box" onclick="showBook()">

                   <a class="box_text" href="#" >??????</a>
               </div>
               <div class="box" onclick="showLend()">

                   <a class="box_text" href="#" >??????</a>
               </div>
               <div class="box" onclick="showCer()">

                   <a class="box_text" href="#" >?????????</a>
               </div>
               <div class="box" onclick="modify()">

                   <a class="box_text" href="#" >????????????</a>
               </div>

           </div>
           <div id="midium">
               <div id="showBook">
                   <div class="main">
                       <div id="book">
                           <div class="book_cond">
                               <form action="" method="get">
                                   ???????????????<input id="min" type="text" name="min" value="">
                                   ???????????????<input id="max" type="text" name="max" value="">
                                   <input type="submit" value="??????" />
                               </form>
                           </div>
                           <div style="text-align: center">
                           </div>


                           <c:forEach items="${sessionScope.page.items}" var="book">
                           <div class="b_list">
                               <div class="img_div">
                                  <img class="book_img" alt="" src="static/img/gai.png" />
                               </div>
                               <div class="book_info">
                                   <div class="book_name">
                                       <span class="sp1">??????:</span>
                                       <span class="sp2">???${book.bkName}???</span>
                                   </div>
                                   <div class="book_author">
                                       <span class="sp1">??????:</span>
                                       <span class="sp2">${book.bkAuthor}</span>
                                   </div>
                                   <div class="book_press">
                                       <span class="sp1">?????????:</span>
                                       <span class="sp2">${book.bkPress}</span>
                                   </div>
                                   <div class="book_price">
                                       <span class="sp1">??????:</span>
                                       <span class="sp2">${book.bkPrice}</span>
                                   </div>
                                   <div class="book_ISBN">
                                       <span class="sp1">ISBN:</span>
                                       <span class="sp2">${book.bkISBN}</span>
                                   </div>
                                   <div class="book_brief">
                                       <span class="sp1">??????:</span>
                                       <span class="sp2">${book.bkBrief}</span>
                                   </div>

                               </div>
                               <div class="book_status">
                                   <span class="sp1">??????:</span>
                                   <span class="sp2">${book.bkStatus}</span>
                               </div>
                               <div class="book_add">
                                   <button bookID="${book.bkID}" class="addToLend">??????</button>
                               </div>


                           </div>
                           </c:forEach>
                       </div>

                       <div id="page_nav">
                           <c:if test="${sessionScope.page.pageNo>1}">

                               <a href="${sessionScope.page.url}&pageNo=1">??????</a>
                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageNo-1}">?????????</a>
                           </c:if>

                           <%--  ?????????????????????--%>
                           <c:choose>
                               <%--??????1???????????????????????????5--%>
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

                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageNo+1}">?????????</a>
                               <a href="${sessionScope.page.url}&pageNo=${sessionScope.page.pageTotal}">??????</a>
                           </c:if>
                           ???${sessionScope.page.pageTotal}??????${sessionScope.page.pageTotalCount}?????????
<%--                           ??????<input value="${param.pageNo}" name="pn" id="pn_input"/>???--%>
<%--                           <input  id="pageButon" type="button" value="??? ???">--%>
<%--                           <script type="text/javascript">--%>
<%--                               $(function (){--%>
<%--                                   $("#pageButon").click(function (){--%>
<%--                                       var pageNo=$("#pn_input").val();--%>
<%--                                       var pageTotal=${requestScope.page.pageTotal};--%>
<%--                                       if(pageNo>1&&pageNo<pageTotal){--%>
<%--                                           location.href="${pageContext.request.contextPath}/${requestScope.page.url}&pageNo="+pageNo;--%>
<%--                                       }else{--%>

<%--                                           alert("error");--%>
<%--                                       }--%>
<%--                                   });--%>
<%--                               });--%>

<%--                           </script>--%>
                       </div>
                   </div>

               </div>
               <div id="showLend" style="display: none">
                 <div id="main">
                     <table>
                         <tr>
                             <td>????????????</td>
                             <td>??????</td>
                             <td>????????????</td>
                             <td>????????????</td>
                             <td>??????</td>
                         </tr>

                         ${sessionScope.cart}

                         <c:if test="${empty sessionScope.cart}">
                             <tr>
                                 <td colspan="5"><a href="pages/rd/login_success.jsp">??????????????????</a> </td>

                             </tr>
                         </c:if>
                         <c:if test="${ not empty sessionScope.cart}">

                         <c:forEach items="${sessionScope.cart}" var="entry">

                         <tr>
                             <td>${entry.bkName}</td>
                             <td>${entry.bkPrice}</td>
                             <td>${sessionScope.lendDate}</td>
                             <td>${sessionScope.readerTtype.canLendDay}</td>
                             <td><a class="deleteItem" href="cartSevlet?action=deleteItem&id=${entry.value.id}">??????</a></td>
                         </tr>
                         </c:forEach>
                         </c:if>
                     </table>
                         <div class="lend_info">
                             <span class="lend_span">???????????? <span class="b_price">2</span>???</span>
                             <span class="lend_span">????????????<span class="b_price">3</span>???</span>
                         </div>
                 </div>
               </div>
               <div id="showCer" style="display: none">
                   <div class="main">
                          <span>
                             </span>
                   <div class="cer">
                       <div class="login_cer">
                           <div class="form">
                               <span style="color: black;font-family: ???????????????;font-size: 30px;margin-left: 120px" >?????????</span>
                               <div class="tit">
                                   <span class="errorMsg" >
                                       <!--									<%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%>-->
								</span>
                               </div>
                               <form action="readerServlet"  method="post">
                                   <input type="hidden" name ="action" value="">
                                   <img style="width: 110px;height: 110px;margin-left: 100px;border-radius:90px " alt="" src="static/img/default.jpg">
                                   <br>
                                   <input type="hidden" name="action" value="regist" autocomplete="off" tabindex="1" name="" >
                                   <label class="login_lab">?????????</label>
                                  <span  class="cer_information">${sessionScope.reader.rdName}</span>
                                   <br>
                                   <label class="login_lab">?????????:</label>
                                   <span class="cer_information">${sessionScope.reader.rdID}</span>
                                   <br>
                                   <label class="login_lab">?????????</label>
                                   <span class="cer_information">${sessionScope.readerType.rdTypeName}</span>
                                   <br>
                                   <label class="login_lab">?????????</label>
                                   <span class="cer_information">${sessionScope.reader.rdDept}</span>
                                    <br>
                                   <label class="login_lab">????????????</label>
                                   <span class="cer_information">${sessionScope.reader.rdPhone}</span>
                                   <br>
                                   <label class="login_lab">?????????</label>
                                   <span class="cer_information">${sessionScope.reader.rdEmail}</span>
                                   <br>
                                   <label class="login_lab">???????????????</label>
                                   <span class="cer_information">${sessionScope.reader.rdDateReg}</span>
                                   <br>
                                   <label class="login_lab">???????????????</label>
                                   <span class="cer_information">${sessionScope.readerType.dateValid}</span>
                                   <br>
                                   <label class="login_lab">?????????</label>
                                   <span class="cer_information" >${sessionScope.reader.rdStatus}</span>
                                   <br>
                                   <button class="certificate_btn">??????</button>
                                   <button class="certificate_btn">??????</button>

                               </form>
                           </div>
                       </div>
                   </div>

                   </div>

               </div>
               <div id="modify" style="display: none">
                   <div class="main">
                       <br>
                       <br>
                   <span style="color: black;font-family: ??????;font-size: 40px;margin-left: 550px;margin-top: 30px" >????????????</span>
                       <br>
                       <br>
                   <div class="login_form">
                       <div class="login_box">
                           <div class="form">
                               <div class="tit">
                                   <span class="errorMsg" id="errorMsg" >

								<%=request.getSession().getAttribute("login_msg")==null?"???????????????":request.getSession().getAttribute("login_msg")%>
								</span>
                               </div>
                               <form action="readerServlet"  method="post">
                                   <input type="hidden" name ="action" value="modify">
                                   <br>
                                   <input type="hidden" name="action" value="modify">
                                   <br>
                                   <label>????????????</label>
                                   <input class="itxt" type="text" placeholder="??????????????????" autocomplete="off" tabindex="1" name="rdPwd" id="rdPwd"/>
                                   <br >
                                   <label>????????????</label>
                                   <input class="itxt" type="password" placeholder="??????????????????" autocomplete="off" tabindex="1" name="password" id="password" />
                                   <br >
                                   <label>???????????????</label>
                                   <input class="itxt" type="password" placeholder="????????????" autocomplete="off" tabindex="1" name="rePwd" id="rePwd" />
                                   <br >
                                   <input type="submit" value="??????" onclick="msg()"  id="sub_btn" />
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
            return confirm("?????????????????????");
        });
    });


    function msg(){
        var rdPwd=$("#rdPwd").val();
        var password=$("#password").val();
        var rePwd=$("#rePwd").val();
        if(rdPwd==password){
            alert("?????????????????????????????????");
        }else{
            if(password==rePwd){
                alert("??????????????????,???????????????!");
            }else{
                alert("???????????????????????????");
            }
        }
    }
  </script>
</html>