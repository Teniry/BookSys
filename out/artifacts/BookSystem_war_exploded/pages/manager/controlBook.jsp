<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <script type="text/javascript" src="../../static/script/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="../../static/css/controlBook.css">
    <base href="http://localhost:8080/bookSystem/">
    <script type="text/javascript">


        function hide(){
            var hide=document.querySelector("#c_form");
            hide.style.display="none";
        }

        function addBook(){
            var add=document.querySelector("#c_form_add");
            add.style.display="block";
        }

        function hide1(){
            var hide=document.querySelector("#c_form_add");
            hide.style.display="none";
        }
    </script>


</head>
<body>

 <div style="width: 100%;height: 100px">
     <div style="padding-left:545px;padding-top: 58px;font-size: 30px">
     <span>
        <b> 图书管理</b>
     </span>
     </div>
 </div>

<div id="main">
    <table>
        <tr>
            <td>图书名称</td>
            <td>作者</td>
            <td>出版社</td>
            <td>单价</td>
            <td>ISBN</td>
            <td>操作</td>

        </tr>
<%--        <c:forEach items="${sessionScope.page.items}" var="book"> --%>
        <c:forEach items="${sessionScope.mcart}" var="book">
        <tr>
                    <td>《${book.bkName}》</td>
                    <td>${book.bkAuthor}</td>
                    <td>${book.bkPress}</td>
                    <td>${book.bkPrice}</td>
                    <td>${book.bkISBN}</td>
                    <td>
                     <button class="edit"  id="edit" bkid="${book.bkID}" onclick="edit()" >编辑</button>
                        <button class="del"   bookID="${book.bkID}" >删除</button>
                    </td>
                </tr>
            </div>

        </c:forEach>
    </table>
</div>

<div  style="margin-left: 966px;margin-top: 18px">
    <span onclick="addBook()"  style="font-size: 20px;color: #ffd80f;text-decoration-line: none;">添加图书</span>
</div>


<!--修改表单-->
<div id="c_form" >
    <form action="managerServlet" method="post">
        <input type="hidden" name="action" value="edit">
        <p style="margin-left: 140px;padding-top: 5px"><b>图书信息</b></p>
        <p>&nbsp;&nbsp;名&nbsp;&nbsp;称&nbsp;&nbsp;：<input name="bkName" id="bkName" type="text"  value=""/></p>
        <p>&nbsp;&nbsp;作&nbsp;&nbsp;者&nbsp;&nbsp;：<input name="bkAuthor"  id="bkAuthor" type="text" value="" /></p>
        <p>&nbsp;&nbsp;出版社&nbsp;：<input name="bkPress" id="bkPress" type="text" value=""></p>
        <p>&nbsp;&nbsp;单&nbsp;&nbsp;价&nbsp;&nbsp;：<input name="bkPrice" id="bkPrice" type="text" value=""></p>
        <p>&nbsp;&nbsp;ISBN&nbsp;&nbsp;&nbsp;：<input name="bkISBN" id="bkISBN" type="text" value=""></p>
        <p>&nbsp;&nbsp;页&nbsp;&nbsp;数&nbsp;&nbsp;：<input name="bkPages" id="bkPages" type="text" value=""></p>
        <p>&nbsp;&nbsp;状&nbsp;&nbsp;态&nbsp;&nbsp;：<input name="bkStatus" id="bkStatus" type="text" value=""></p>
        <p>&nbsp;&nbsp;简&nbsp;&nbsp;介&nbsp;&nbsp;：<textarea name="bkBrief"  id="bkBrief"  value=""  style="width: 250px;height: 100px;overflow: scroll"></textarea></p>

        <div style="width: 100%">
            <input class=f_btn" id="save" onclick="hide()" type="submit" style="margin-left: 130px"  value="保存">
            <button type="button" class="f_btn" onclick="hide()"  >取消</button>
        </div>
    </form>
</div>

<!--添加图书-->
<div id="c_form_add" >
    <form action="managerServlet" method="post">
        <input type="hidden" name="action" value="add">
        <p style="margin-left: 140px;padding-top: 5px"><b>图书信息</b></p>
        <p>&nbsp;&nbsp;名&nbsp;&nbsp;称&nbsp;&nbsp;：<input name="bkName"  type="text"  /></p>
        <p>&nbsp;&nbsp;作&nbsp;&nbsp;者&nbsp;&nbsp;：<input name="bkAuthor"   type="text"  /></p>
        <p>&nbsp;&nbsp;出版社&nbsp;：<input name="bkPress"  type="text" ></p>
        <p>&nbsp;&nbsp;单&nbsp;&nbsp;价&nbsp;&nbsp;：<input name="bkPrice"  type="text" ></p>
        <p>&nbsp;&nbsp;ISBN&nbsp;&nbsp;&nbsp;：<input name="bkISBN"  type="text" ></p>
        <p>&nbsp;&nbsp;页&nbsp;&nbsp;数&nbsp;&nbsp;：<input name="bkPages"  type="text" ></p>
        <p>&nbsp;&nbsp;状&nbsp;&nbsp;态&nbsp;&nbsp;：<input name="bkStatus"  type="text" ></p>
        <p>&nbsp;&nbsp;简&nbsp;&nbsp;介&nbsp;&nbsp;：<textarea name="bkBrief"     type="text" style="width: 250px;height: 100px;overflow: scroll"></textarea></p>

        <div style="width: 100%">
            <input class=f_btn" id="save_add" onclick="hide1()" type="submit" style="margin-left: 130px"  value="保存">
            <button type="button" class="f_btn" onclick="hide1()" >取消</button>
        </div>
    </form>
</div>

</body>

<script type="text/javascript">

     $(function (){
         $(".del").click(function (){
             var obj=confirm("您确定要删除吗？");
             var bookId=$(this).attr("bookID");
             if(obj){
                 $.ajax({
                     url:"http://localhost:8080/bookSystem/managerServlet",
                     error: function () {
                         alert("请求失败");
                     },
                     success: function (data) {
                         alert(data.del);
                         window.location.reload();
                     },
                     type: "POST",
                     dataType: "json",
                     data: {
                         action: "delete",
                         id: bookId
                     },
                 });
             }


         });


         $(".edit").click(function (){

             var show = document.querySelector("#c_form");
             var id = $(this).attr("bkid");
             // show.style.display="block";
             var obj = confirm("您确定要编辑吗？");
             if (obj) {
                 $.ajax({
                     url: "http://localhost:8080/bookSystem/managerServlet",
                     error: function () {
                         alert("请求失败");
                     },
                     success: function (data) {
                         show.style.display = "block";
                         document.getElementById("bkName").value=data.bkname;
                         document.getElementById("bkAuthor").value=data.bkauthor;
                         document.getElementById("bkPrice").value=data.bkprice;
                         document.getElementById("bkPress").value=data.bkpress;
                         document.getElementById("bkPages").value=data.bkpages;
                         document.getElementById("bkStatus").value=data.bkstatus;
                         document.getElementById("bkISBN").value=data.bkisbn;
                         document.getElementById("bkBrief").value=data.bkbrief;
                     },
                     type: "POST",
                     dataType: "json",
                     data: {
                         action: "form",
                         id: id
                     },
                 });
             }
         });

     });

</script>
</html>