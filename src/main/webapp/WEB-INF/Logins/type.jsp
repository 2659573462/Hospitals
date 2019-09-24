<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>医院管理系统</title>
    <link rel="stylesheet" />
    <link rel="stylesheet" href="css/Site.css" />
    <link rel="stylesheet" href="css/zy.all.css" />
    <link rel="stylesheet" href="css/font-awesome.min.css" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
    <link rel="stylesheet" href="css/admin.css" />
    <!-- Bootstrap -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">;
    <link href="/css/toastr.min.css" rel="stylesheet">;
    <style>

    </style>
<body>
<div class="dvcontent">

    <div>
        <!--tab start-->
        <div class="tabs">
            <div class="hd">
                <ul style="">
                    <li style="box-sizing: initial;-webkit-box-sizing: initial;" class="on">查看分类</li>
                    <li class="" style="box-sizing: initial;-webkit-box-sizing: initial;">添加分类</li>
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
                                    <th>分类编号</th>
                                    <th>分类名称</th>
                                    <th>分类描述</th>
                                    <th>备注</th>
                                    <th>编辑</th>
                                    <th>删除</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>肉类</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(1)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(1)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>蔬菜</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(2)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(2)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>海鲜</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(3)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(3)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>4</td>
                                    <td>调料</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(4)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(4)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>5</td>
                                    <td>主食</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(5)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(5)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>6</td>
                                    <td>甜品</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(6)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(6)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>7</td>
                                    <td>猪肉</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(7)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(7)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>8</td>
                                    <td>牛肉</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(8)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(8)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>9</td>
                                    <td>五花肉</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(9)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(9)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                <tr>
                                    <td>10</td>
                                    <td>肉末</td>
                                    <td> </td>
                                    <td> </td>
                                    <td class="edit"><button onclick="btn_edit(10)"><i class="icon-edit bigger-120"></i>编辑</button></td>
                                    <td class="delete"><button onclick="btn_delete(10)"><i class="icon-trash bigger-120"></i>删除</button></td>
                                </tr>
                                </tbody>

                            </table>
                        </div>
                    </li>
                    <!--分页显示角色信息 end-->
                    <div class="text-center">
                        <nav aria-label="Page navigation">
                            <ul class="pagination">
                                <c:if test="${page.currentPage > 1}">
                                    <li>
                                        <a href="${pageScope.request.contextPath}/book/list?p=${page.currentPage - 1}">
                                            <span>&laquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                                <c:forEach begin="1" end="${page.pageCount}" step="1" var="p">
                                    <c:if test="${page.currentPage == p}">
                                        <li class="active">
                                            <a href="${pageScope.request.contextPath}/book/list?p=${1}">${1}</a>
                                        </li>
                                    </c:if>
                                    <c:if test="${page.currentPage != p}">
                                        <li>
                                            <a href="${pageScope.request.contextPath}/book/list?p=${2}">${2}</a>
                                        </li>
                                    </c:if>
                                </c:forEach>
                                <c:if test="${page.currentPage < page.pageCount}">
                                    <li>
                                        <a href="${pageScope.request.contextPath}/book/list?p=${page.currentPage + 1}">
                                            <span>&raquo;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </ul>
                        </nav>
                    </div>




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
                                                  action="user/addUser1Submit.action" method="post">

                                                <div class="am-form-group">
                                                    <label for="user-name" class="am-u-sm-3 am-form-label">
                                                        分类名称</label>
                                                    <div class="am-u-sm-9">
                                                        <input type="text" id="user-name" required
                                                               placeholder="分类名称" name="name">
                                                        <small>10字以内...</small>
                                                    </div>
                                                </div>
                                                <div class="am-form-group">
                                                    <label for="user-intro" class="am-u-sm-3 am-form-label">
                                                        备注</label>
                                                    <div class="am-u-sm-9">
									<textarea class="" rows="5" id="user-intro" name="remark"
                                              placeholder="输入备注"></textarea>
                                                        <small>250字以内...</small>
                                                    </div>
                                                </div>
                                                <div class="am-form-group">
                                                    <div class="am-u-sm-9 am-u-sm-push-3">
                                                        <input type="submit" class="am-btn am-btn-success" value="添加分类" />
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
                </ul>
            </div>
        </div>
        <!--tab end-->

    </div>


    <!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
    <script src="/js/jquery.min.js"></script>
    <!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
    <script src="/js/bootstrap.min.js"></script>
    <script src="/js/my.js"></script>
    <script src="/js/toastr.min.js"></script>


    <script src="js/jquery-1.7.2.min.js" type="text/javascript"></script>
    <script src="js/plugs/Jqueryplugs.js" type="text/javascript"></script>
    <script src="js/plugs/jquery.SuperSlide.source.js"></script>
    <script>

        var num = 1;
        $(function() {

            $(".tabs").slide({ trigger: "click" });

        });


        var btn_save = function() {
            var pid = $("#RawMaterialsTypePageId  option:selected").val();
            var name = $("#RawMaterialsTypeName").val();
            var desc = $("#RawMaterialsTypeDescription").val();
            var ramark = $("#Ramark").val();
            $.ajax({
                type: "post",
                url: "/RawMaterialsType/AddRawMaterialsType",
                data: { name: name, pid: pid, desc: desc, ramark: ramark },
                success: function(data) {
                    if(data > 0) {
                        $.jq_Alert({
                            message: "添加成功",
                            btnOktext: "确认",
                            dialogModal: true,
                            btnOkClick: function() {
                                //$("#RawMaterialsTypeName").val("");
                                //$("#RawMaterialsTypeDescription").val("");
                                //$("#Ramark").val("");
                                //page1();
                                location.reload();

                            }
                        });
                    }
                }
            });
            alert(t);
        }

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
                        type: "post",
                        url: "/RawMaterialsType/DeleteRawMaterialsType",
                        data: { id: id },
                        success: function(data) {
                            if(data > 0) {
                                $.jq_Alert({
                                    message: "删除成功",
                                    btnOkClick: function() {
                                        page1();
                                    }
                                });
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
