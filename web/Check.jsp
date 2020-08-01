<%@ page import="java.util.List" %>
<%@ page import="entity.QuestionnaireResults" %>
<%@ page import="daoimpl.QuestionnaireDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/7/31
  Time: 下午 5:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Check</title>
    <link rel="stylesheet" type="text/css" href="css/questionnaire_style.css">
</head>
<body>
<%--<h1>check<%=page%></h1>--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    String id = request.getParameter("page");//用request得到
    QuestionnaireDaoImpl questionnaireDao=new QuestionnaireDaoImpl();
    List<QuestionnaireResults> list=questionnaireDao.findBy(id);
    QuestionnaireResults res=list.get(0);
%>
<%--<h1>${param.page}</h1>--%>
<div id="header">
    <h1 style="text-align: center;margin: 0 auto">大学生诚信意识调查</h1>
</div>

<div id="table">
    <form id="form" action="${pageContext.request.contextPath}/submit" method="post">
        <div class="question">
            <p>1、您所在的年级是？</p>
            <label>
                <input type="radio" name="que_1" value="a" disabled>
                大一
            </label>
            <br>
            <label>
                <input type="radio" name="que_1" value="b" disabled>
                大二
            </label>
            <br>
            <label>
                <input type="radio" name="que_1" value="c" disabled>
                大三
            </label>
            <br>
            <label>
                <input type="radio" name="que_1" value="d" disabled>
                大四
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[0]%></p>
            </div>
        </div>
        <div class="question">
            <p>2、您对诚信的理解</p>

            <label>
                <input type="radio" name="que_2" value="a" disabled>
                凡事言必行，行必果
            </label>
            <br>
            <label>
                <input type="radio" name="que_2" value="b" disabled>
                允许在特殊情况下有失信行
            </label>
            <br>
            <label>
                <input type="radio" name="que_2" value="c" disabled>
                认为无所谓，但自己要讲诚信
            </label>
            <br>
            <label>
                <input type="radio" name="que_2" value="d" disabled>
                遵纪守法，安全负责
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[1]%></p>
            </div>
        </div>
        <div class="question">
            <p>3、您认为自己是一个讲诚信的人吗？</p>

            <label>
                <input type="radio" name="que_3" value="a" disabled>
                是，诚信是基本道德，一向严格要求自己
            </label>
            <br>
            <label>
                <input type="radio" name="que_3" value="b" disabled>
                基本是，特殊情况下会不诚信
            </label>
            <br>
            <label>
                <input type="radio" name="que_3" value="c" disabled>
                不是，诚信对我来说可有可无
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[2]%></p>
            </div>
        </div>
        <div class="question">
            <p>4、你觉得生活中细小事情能反映一个人的诚信意识吗？</p>

            <label>
                <input type="radio" name="que_4" value="a" disabled>
                能
            </label>
            <br>
            <label>
                <input type="radio" name="que_4" value="b" disabled>
                不能
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[3]%></p>
            </div>
        </div>
        <div class="question">
            <p>5、在大学期间您是否有过考试作弊行为？</p>

            <label>
                <input type="radio" name="que_5" value="a" disabled>
                经常作弊但均未被发现
            </label>
            <br>
            <label>
                <input type="radio" name="que_5" value="b" disabled>
                曾经有过作弊行为但未被发现
            </label>
            <br>
            <label>
                <input type="radio" name="que_5" value="c" disabled>
                有过作弊想法，但未付诸行动
            </label>
            <br>
            <label>
                <input type="radio" name="que_5" value="d" disabled>
                从未有过作弊想法及行为
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[4]%></p>
            </div>
        </div>
        <div class="question">
            <p>6、在大学期间您是否有过论文抄袭行为？</p>

            <label>
                <input type="radio" name="que_6" value="a" disabled>
                经常抄袭
            </label>
            <br>
            <label>
                <input type="radio" name="que_6" value="b" disabled>
                偶尔抄袭
            </label>
            <br>
            <label>
                <input type="radio" name="que_6" value="c" disabled>
                有过抄袭想法，但均未付诸行动
            </label>
            <br>
            <label>
                <input type="radio" name="que_6" value="d" disabled>
                从未有过抄袭想法及行为
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[5]%></p>
            </div>
        </div>
        <div class="question">
            <p>7、您对论文抄袭、考试作弊等现象的看法是？</p>

            <label>
                <input type="radio" name="que_7" value="a" disabled>
                可以理解
            </label>
            <br>
            <label>
                <input type="radio" name="que_7" value="b" disabled>
                这是品质问题，绝对不可以
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[6]%></p>
            </div>
        </div>
        <div class="question">
            <p>8、您所在的学校是否举办过关于诚信的讲座，或开展过相关活动？</p>

            <label>
                <input type="radio" name="que_8" value="a" disabled>
                偶尔
            </label>
            <br>
            <label>
                <input type="radio" name="que_8" value="b" disabled>
                经常
            </label>
            <br>
            <label>
                <input type="radio" name="que_8" value="c" disabled>
                从来没有
            </label>
            <br>
            <div>
                <p style="color:red;">用户的选择是<%=res.getChoice()[7]%></p>
            </div>
        </div>
    </form>
</div>
</body>
</html>
