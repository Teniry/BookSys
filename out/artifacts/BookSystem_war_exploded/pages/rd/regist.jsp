<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>图书管理系统</title>
	<%@include file="../../pages/common/head.jsp"%>
</head>
<body>

<div id="login_header">
	<img class="logo_img" alt="" src="static/img/changjiang.jpg" >
	<!--<span id="heaedr_content" style="font-size: 40px;color: black;font-family:宋体;padding-top: 50px" >图书管理系统</span>-->
	<h1 style="color: black;font-family: 宋体;font-size: 39px;padding-top: 25px"><b>图书管理系统</b></h1>
</div>
<div class="login_banner">

	<div id="l_content">
		<span class="login_word" style="font-size: 60px;color: #e3e3e3">欢迎申请</span>
	</div>


	<div id="content">
		<div class="login_form" style="height: 433px;margin-top: 25px">
			<div class="login_box">
				<div class="tit">
					<h1>读者用户申请</h1>
					<div class="msg_cont">
					<span class="errorMsg" >

					    <%=request.getSession().getAttribute("rmsg")==null?"":request.getSession().getAttribute("rmsg")%>
              </span>
						</div>
				</div>
				<div class="form">

					<form action="readerServlet"  method="post">
						<input type="hidden" name="action" value="regist">
						<label>学&nbsp;&nbsp;&nbsp;&nbsp;号&nbsp;&nbsp;&nbsp;：</label>
						<input class="itxt" type="text" placeholder="请输入学号"
							   value="<%=request.getSession().getAttribute("r_rdID")==null?"":request.getSession().getAttribute("r_rdID")%>"
							   autocomplete="off" tabindex="1" name="rdID" id="rdID" />
						<br />
						<br />
						<label>姓&nbsp;&nbsp;&nbsp;&nbsp;名&nbsp;&nbsp;&nbsp;：</label>
						<input class="itxt" type="text" placeholder="请输入姓名"  autocomplete="off" tabindex="1"
						     name="username" id="username" value="<%=request.getSession().getAttribute("r_username")==null?"":request.getSession().getAttribute("r_username")%>"/>
						<br />
						<br/>
						<label>用户密码：</label>
						<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
						<br />
						<br />
						<label>确认密码：</label>
						<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
						<br />
						<br />
						<label>电子邮件：</label>
						<input class="itxt" type="text" placeholder="请输入邮箱地址"
							   value="<%=request.getSession().getAttribute("email")==null?"":request.getSession().getAttribute("r_email")%>"
							   autocomplete="off" tabindex="1" name="email" id="email" />
                          <br>
						<br>

						<input type="submit" value="申请" id="sub_btn" />

					</form>
				</div>

			</div>
		</div>
	</div>

	<%@include file="../../pages/common/footer.jsp"%>
</div>


</body>


</html>