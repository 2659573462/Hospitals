<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>医院管理系统</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" />
    <link rel="stylesheet" href="css/Site.css" />
    <link rel="stylesheet" href="css/zy.all.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
    <link rel="stylesheet" href="css/admin.css" />
    <style>
        tr>td:nth-child(-n+6){
            text-indent:20px;
        }

    </style>
    <script>
        var i = 0;
        if (i < 1) {
            function modify(id) {
                $.ajax({
                    type: "get",
                    url: "${pageScope.request.contextPath}/HospitalsServlet?transmits=selectId",
                    data: {"id": id},
                    success: function (result) {
                        var obj =JSON.parse(result);
                        $("#employeescard").val(obj.employeescard)
                        $("#doctorname").val(obj.doctorname)
                        if(obj.gender=="男"){
                            $('.form-horizontal input[type="radio"]:first').prop('checked', 'true')
                        }else{
                            $('.form-horizontal input[type="radio"]:last').prop('checked', 'true')
                        }
                        $("#age").val(obj.age)
                        $("#subordinatedepartments").val(obj.subordinatedepartments)
                        $("#educationbackground").val(obj.educationbackground)
                    }
                }, 'json');
                i++;


            }
        }
    </script>
<body style="height:714px">
<div class="dvcontent" >

    <div>
        <!--tab start-->
        <div class="tabs">
            <div class="hd">
                <ul style="">
                    <li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">查看人员</li>
                    <li class="" style="box-sizing: initial;-webkit-box-sizing: initial;">添加人员</li>
                </ul>
            </div>
            <div class="bd">
                <ul style="display: block;padding: 20px;">
                    <li>
                        <!--分页显示角色信息 start-->
                        <div id="dv1">
                            <table class="table" id="tbRecord">
                                <thead>
                                <tr>
                                    <th>工作证号</th>
                                    <th>医生名称</th>
                                    <th>性别</th>
                                    <th>年龄</th>
                                    <th>所属科室</th>
                                    <th>学历</th>
                                    <th>编辑</th>
                                    <th>删除</th>
                                </tr>
                                <c:forEach items="${cards.pageData}" var="hospitals">
                                    <tr>
                                        <td>${hospitals.employeescard}</td>
                                        <td>${hospitals.doctorname}</td>
                                        <td>${hospitals.gender}</td>
                                        <td>${hospitals.age}</td>
                                        <td>${hospitals.subordinatedepartments}</td>
                                        <td>${hospitals.educationbackground}</td>
                                        <td>
                                            <a class="btn btn-primary btn-sm" data-toggle="modal" data-target="#myModal" onmouseover="modify('${hospitals.employeescard}')">
                                            修改</a>
                                        </td>
                                        <td>
                                            <a class="btn btn-danger btn-sm del" href="#" onclick="btn_delete('${hospitals.employeescard}')" ><i class="icon-trash bigger-120" ></i>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </thead>


                            </table>
                        </div>
                        <!--分页显示角色信息 end-->
                    </li>





                    <nav aria-label="Page navigation">
                        <ul class="pagination">
                            <li>
                                <a href="${pageScope.request.contextPath}/HospitalsServlet?transmits=indexHospitaltaffS&p=${cards.currentPage-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                </a>
                            </li>
                            <c:forEach begin="1" end="${cards.pageCount}" step="1" var="p">
                            <c:if test="${cards.currentPage == p}">
                            <li >
                                <a href="${pageScope.request.contextPath}/HospitalsServlet?transmits=indexHospitaltaffS&p=${p}">${p}</a>
                            </li>
                            </c:if>
                            <c:if test="${cards.currentPage != p}">
                            <li>
                                 <a href="${pageScope.request.contextPath}/HospitalsServlet?transmits=indexHospitaltaffS&p=${p}">${p}</a>
                             </li>
                            </c:if>
                            </c:forEach>
                            <li>
                                <a href="${pageScope.request.contextPath}/HospitalsServlet?transmits=indexHospitaltaffS&p=${cards.currentPage+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                </a>
                            </li>
                        </ul>
                    </nav>


                </ul>
                <ul class="theme-popbod dform" style="display: none;">
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
                                                  action="${pageScope.request.contextPath}/HospitalsServlet?transmits=addHospitals" method="post">

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        工作证号</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text" id="user-name" required
                                                               placeholder="" name="employeescard">
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        医生姓名</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text"  required
                                                               placeholder="" name="doctorname">
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        性别</label>
                                                    <div class="am-u-sm-9">
                                                        <input  type="radio" checked="checked" name="gender" value="男" />男
                                                        <input  type="radio"  name="gender" value="女"/>女
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        年龄</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text" id=""  required
                                                               placeholder="" name="age">
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        所属科室</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text" required
                                                               placeholder="" name="subordinatedepartments">
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        学历</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text"  required
                                                               placeholder="" name="educationbackground">
                                                    </div>
                                                </div>

                                                <div class="am-form-group">
                                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                                        <input type="submit" class="am-btn am-btn-success" value="添加医生" />
                                                    </div>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>

                            </div>
                            <!-- content end -->
                        </div>
                        <!-- end-->
                    </div>
                </ul>

            </div>
        </div>
        <!--tab end-->
        <!--修改弹框-->
        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                        </button>
                        <h4 class="modal-title" id="myModalLabel">修改医生信息</h4>
                    </div>
                    <div class="modal-body">
                        <div class="container">

                            <div class="row">
                                <form class="form-horizontal" action="${pageScope.request.contextPath}/HospitalsServlet?transmits=updateHospitals"
                                      method="post">
                                    <div style="width:900px;" class="form-group">
                                        <label for="employeescard" class="col-md-2 control-label">工作证号:</label>
                                        <div class="col-md-6">
                                            <input style="width:300px;" type="text" class="form-control" id="employeescard"   readonly="readonly"
                                                   name="employeescard" />
                                        </div>
                                    </div>
                                    <div style="width:900px;" class="form-group">
                                        <label for="doctorname" class="col-md-2 control-label">医生名称:</label>
                                        <div class="col-md-6">
                                            <input style="width:300px;" type="text" class="form-control"
                                                   id="doctorname" name="doctorname"  />
                                        </div>
                                    </div>
                                    <div style="width:900px;" class="form-group">
                                        <label  class="col-md-2 control-label">性别:</label>
                                        <div class="col-md-6">
                                            <input  type="radio"  name="gender" value="男" />男
                                            <input  type="radio"  name="gender" value="女"/>女
                                        </div>
                                    </div>
                                    <div style="width:900px;" class="form-group">
                                        <label for="age" class="col-md-2 control-label">年龄：</label>
                                        <div class="col-md-6">
                                            <input style="width:300px;" type="text" class="form-control" id="age"
                                                   name="age"  min="0" value="0" onkeyup="value=value.replace(/[^\d]/g,'')" placeholder="请输入数字")/>
                                        </div>
                                    </div>
                                    <div style="width:900px;" class="form-group">
                                        <label for="subordinatedepartments" class="col-md-2 control-label">所属科室：</label>
                                        <div class="col-md-6">
                                            <input style="width:300px;" type="text" class="form-control" id="subordinatedepartments"
                                                   name="subordinatedepartments" />
                                        </div>
                                    </div>
                                    <div style="width:900px;" class="form-group">
                                        <label for="educationbackground" class="col-md-2 control-label">学历:</label>
                                        <div class="col-md-6">
                                            <input style="width:300px;" type="text"  class="form-control"
                                                   id="educationbackground" name="educationbackground"  />
                                        </div>
                                    </div>
                                    <div style="width:560px;" class="form-group text-center">
                                        <button type="submit" class="btn btn-primary"   >提交</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>

    </div>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="js/plugs/Jqueryplugs.js" type="text/javascript"></script>
    <script src="js/_layout.js"></script>
    <script src="js/plugs/jquery.SuperSlide.source.js"></script>



    <script>
        var num = 1;
        $(function() {

            $(".tabs").slide({ trigger: "click" });

        });



        var btn_edit = function(id) {
            $.jq_Panel({
                url: "/RawMaterialsType/EditRawMaterialsType?id=" + id,
                title: "编辑分类",
                dialogModal: true,
                iframeWidth: 500,
                iframeHeight: 400
            });
        }
        var btn_delete = function(id) {
            $.jq_Confirm({
                message: "您确定要删除吗?",
                btnOkClick: function() {
                    $.ajax({
                        type: "get",
                        url: "${pageScope.request.contextPath}/HospitalsServlet?transmits=deleteHospitals",
                        data: { id: id },
                        success: function(result) {
                            if(result) {
                                // console.log(result.i)
                                // alert("用户名可以被使用");
                                message: "删除成功";
                                window.location.reload();
                            }
                        }
                    });
                }
            });
        }
    </script>

</div>
</body>

</html>