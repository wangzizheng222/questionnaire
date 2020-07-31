<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/7/30
  Time: 上午 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <style>
        .btn {
            display: inline-block;
            border: 2px solid #ba5555;
            border-radius: 5px;
            font-size: 18px;
            font-weight: 700;
            line-height: 1;
            color: #ba5555;
            height: 50px;
            width: 150px;
            outline: none;

            margin: 0 auto;
        }
        .btn:hover {
            color: #ff0000;
            border-color: #ff0000;
            cursor: pointer;
        }
        body{
            display: flex;
            flex-direction: column;
        }

        #form{
            display: flex;
            flex-direction: column;
            margin: 0 auto;

            width: 50%;
            height: 400px;
        }

        input[type="text"],input[type="password"]{
            font-size: 1em;
            color: #ff0000;
            font-weight:100;
            border: none;
            border-bottom: solid 3px #ff0000;
            background-color: transparent;
            width: 240px;
            height: 60px;
            text-align: center;
        }

        input:focus,input:valid{
            outline: none;
            box-shadow: none;
        }

        text:focus,text:valid{
            box-shadow: none;
            outline: none;
        }

        #submit{
            margin: 0 auto;
        }


    </style>
</head>
<body>
<div id="header">
    <h1 style="text-align: center;margin: 0 auto">登录</h1>
</div>

<div id="form">
    <form id="table" action="${pageContext.request.contextPath}/login" method="post">
        <div>
            <h2>登录</h2>
        </div>
        <div>
            <label>
                用户名
                <input type="text" name="name">
            </label>
        </div>

        <div>
            <label>
                密码
                <input type="password" name="password">
            </label>
        </div>
    </form>
</div>

<div id="submit">
    <button class="btn" onclick="submit()">
        提交
    </button>
</div>
<script>
    function submit() {
        document.getElementById("table").submit();
    }
</script>
</body>
</html>
