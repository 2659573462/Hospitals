<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>爱丽丝医院后台管理系统</title>
    <link href="css/login.css" rel="stylesheet" type="text/css" />
    <link rel="icon" type="image/x-icon" href="img/admei.ico"/>
    <script>
        window.onload = function () {
            if (window.top != window.self) {
                top.location.href = location.href;
            }
        }
    </script>
</head>

<body>
<form class="form-horizontal" action="/HospitalsServlet?transmits=LoginRequest" method="post">
<div class="login_box">
    <div class="login_l_img"><img src="images/login-img.png" /></div>
    <div class="login">
        <div class="login_logo"><a href="#"><img src="images/login_logo.png" /></a></div>
        <div class="login_name">
            <p>爱丽丝医院后台管理系统</p>
        </div>
        <form method="post">
            <input name="username" type="text"  value="用户名" onfocus="this.value=''" onblur="if(this.value==''){this.value='用户名'}">
            <span id="password_text" onclick="this.style.display='none';document.getElementById('password').style.display='block';document.getElementById('password').focus().select();" >密码</span>
            <input name="password" type="password" id="password" style="display:none;" onblur="if(this.value==''){document.getElementById('password_text').style.display='block';this.style.display='none'};"/>
            <label>
                <input type="checkbox" value="1" name="remember"> 记住我
            </label>
            <div>
            <p class="text-danger" style="color:red">${error}</p>
            </div>
            <input value="登录" style="width:100%;" type="submit">
        </form>
    </div>
    <div class="copyright" style="margin-top: 288px;">爱丽丝医院有限公司 版权所有©2016-2020 技术支持电话：000-1816132691</div>
</div>
</form>
</body>
</html>
