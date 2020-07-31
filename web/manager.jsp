<%@ page import="java.util.List" %>
<%@ page import="entity.QuestionnaireResults" %>
<%@ page import="java.io.IOException" %><%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/7/30
  Time: 上午 9:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Manager</title>
    <style>
        body{
            display: flex;
            flex-direction: column;
        }

        #list{
            display: flex;
            flex-direction: column;

            width: 100%;
        }

        #list_value{
            width: 100%;
            height: 100px;
        }

        #header{
            width: 100%;
        }

        #control{
            width: 100%;
            height: 100px;
        }

        #list_value a{
            background-color: darkgrey;
            font-size: 25px;
            width: 100%;
        }
    </style>
</head>
<body>
<div id="header">
    <h1 style="text-align: center;margin: 0 auto">后台管理</h1>
</div>
<div id="control">

</div>
<div id="list">
    <h2 style="margin: 0 auto">问卷调查结果列表</h2>
    <%!List<QuestionnaireResults> list;%>
    <%
        list= (List<QuestionnaireResults>) request.getAttribute("list");

    %>
    <%!
        void printTable(JspWriter out) throws IOException {
            for (QuestionnaireResults questionnaireResults : list) {
                out.println("<div id=\"list_value\">");
                out.println("<a id=\"" + questionnaireResults.getId() + "\" onclick=\"take_a_look(this)\">");
                out.println("<label style=\"margin-left: 0\">问卷结果" + questionnaireResults.getId() + "</label>");
                out.println("<label style=\"margin-right: 0\">" + questionnaireResults.getDate() + "</label>");
                out.println("</a>");
                out.println("</div>");
            }
        }
    %>
    <%printTable(out);%>

    <%--<div id="list_value">
        <a id="<%=list.get(0).getId()%>" onclick="take_a_look(this)">
            <label style="margin-left: 0">问卷结果<%=list.get(0).getId()%></label>
            <label style="margin-right: 0"><%=list.get(0).getDate()%></label>
        </a>
    </div>--%>

</div>

<script>
    let value="";
    <%! int j=0;%>

    for (let j=0;j<parseInt(<%=list.size()%>);j++){
        value=value+"<div id=\"list_value\">\n" +
            "        <a id=\"<%=list.get(j).getId()%>\" onclick=\"take_a_look(this)\">\n" +
            "            <label style=\"margin-left: 0\">问卷结果<%=list.get(j).getId()%></label>\n" +
            "            <label style=\"margin-right: 0\"><%=list.get(j).getDate()%></label>\n" +
            "        </a>\n" +
            "    </div>"
        <%
        j=j+1;
        %>
    }
    // document.getElementById("list").innerHTML=value;

    function take_a_look(data) {
        window.location="Check.jsp?page=" + data.id;
    }
</script>

</body>
</html>
