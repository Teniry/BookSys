<%--
  Created by IntelliJ IDEA.
  User: 小腾同学
  Date: 2022/10/5
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>图书管理系统</title>
    <%@include file="pages/common/head.jsp"%>
  </head>
  <body>

  <div id="login_header">
    <img class="logo_img" alt="" src="static/img/changjiang.jpg" >
    <!--<span id="heaedr_content" style="font-size: 40px;color: black;font-family:宋体;padding-top: 50px" >图书管理系统</span>-->
    <h1 style="color: black;font-family: 宋体;font-size: 39px;padding-top: 25px"><b>图书管理系统</b></h1>
  </div>
  <div class="login_banner">

    <div id="l_content">
      <span class="login_word" style="font-size: 60px;color: #e3e3e3">欢迎登录</span>
    </div>


    <div id="content">
      <div class="login_form">
        <div class="login_box">
          <div class="tit">
            <h1>用户登录</h1>

          </div>
          <div class="msg_cont">
            <b></b>
            <span class="errorMsg">
              <span class="errorMsg">
<%--	<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>--%>
								     ${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}
              </span>
			</span>
          </div>
          <div class="form">
            <form action="readerServlet" method="post">
              <input type="hidden" name ="action" value="login">
              <label>用户名称：</label>
              <input class="itxt" type="text" placeholder="请输入编号" autocomplete="off" tabindex="1" name="rdID"
                     value="${sessionScope.rdID}" />
              <br />
              <br />
              <label>用户密码：</label>
              <input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="rdPwd" />
              <br />
              <br />
              <input type="submit" value="登录" id="sub_btn" />
            </form>
          </div>
          <a href="${pageContext.request.contextPath}/web/pages/user/regist.jsp"   id="req">立即申请</a>
        </div>
      </div>
    </div>

    <%@include file="pages/common/footer.jsp"%>
  </div>


  </body>


</html>