<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/Site.css" />
    <link rel="stylesheet" href="css/zy.all.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
    <link rel="stylesheet" href="css/admin.css" />
</head>
<body>
<div class="am-cf admin-main" style="padding-top: 0px;">
    <!-- content start -->

    <div class="am-cf admin-main" style="padding-top: 0px;">
        <!-- content start -->
        <div class="admin-content">
            <div class="admin-content-body">

                <div class="am-g">
                    <div class="am-u-sm-12 am-u-md-4 am-u-md-push-8">

                    </div>
                    <div class="am-u-sm-12 am-u-md-8 am-u-md-pull-4"
                         style="padding-top: 30px;">
                        <form class="am-form am-form-horizontal"
                              action="${pageScope.request.contextPath}/HospitalsServlet?transmits=updatePaws" method="post">

                            <div class="am-form-group">
                                <label for="users-name" class="am-u-sm-3 am-form-label">
                                    原密码</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="users-name" required
                                           placeholder="原密码" name="name">
                                    <small>原密码...</small>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <label for="usert-name" class="am-u-sm-3 am-form-label">
                                    新密码</label>
                                <div class="am-u-sm-9">
                                    <input type="text" id="usert-name" required
                                           placeholder="新密码" name="nameft">
                                    <small>新密码...</small>
                                </div>
                            </div>
                            <div class="am-form-group">
                                <div class="am-u-sm-9 am-u-sm-push-3">
                                    <input type="submit" class="am-btn am-btn-success" value="修改" />
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
            <footer class="admin-content-footer">
                <hr>
                <p class="am-padding-left"></p>
            </footer>
        </div>
        <!-- content end -->
    </div>
</div>
    <!-- end-->
</body>
</html>