<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/7/29
  Time: 上午 9:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
    <link type="text/css" rel="stylesheet" href="css/index_style.css">
  </head>
  <body>
  <div id="header">
    <h1>问卷调查系统</h1>
  </div>

  <div id="control">
    <button class="btn" onclick="goto_manager()">后台管理入口</button>
  </div>

  <div id="list">
    <h2>问卷列表</h2>
    <div class="question_list">
      <a onclick="goto_question()">大学生诚信意识调查</a>
      <hr>
    </div>

    <div class="question_list">
      <a>创意平台调查问卷</a>
      <hr>
    </div>
  </div>

  <div id="footer">

  </div>

  </body>

<script>
  function goto_manager() {
    // window.location.href="/questionnaire_war_exploded/login/"
    window.location="questionnaire.jsp"
  }

  function goto_question() {
    window.location="questionnaire.jsp"
  }
</script>
</html>
