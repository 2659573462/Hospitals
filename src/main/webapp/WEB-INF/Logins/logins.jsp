<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>医院管理系统</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/Site.css" rel="stylesheet" type="text/css" />
    <link href="../../css/zy.layout.css" rel="stylesheet" />
    <link href="../../css/zy.form.css" rel="stylesheet" />
    <link rel="icon" type="image/x-icon" href="img/admei.ico"/>
<%--    <link href="../../css/font-awesome.min.css" rel="stylesheet" />--%>
    <style type="text/css">
        .headerlitooleulsubitem_gray {
            background-Color: White;
            position: absolute;
            border-left: 1px solid #BCD4E5;
            border-right: 1px solid #BCD4E5;
            border-bottom: 1px solid #BCD4E5;
            box-shadow: 0px 0px 5px #BCD4E5;
            width: 230px;
            margin-left: -170px;
            color: Black;
            display: none;
        }

        .headerlitooleulsubitem_red {
            background-Color: White;
            position: absolute;
            border-left: 1px solid #E5BCD4;
            border-right: 1px solid #E5BCD4;
            border-bottom: 1px solid #E5BCD4;
            box-shadow: 0px 0px 5px #E5BCD4;
            width: 230px;
            margin-left: -170px;
            color: Black;
            display: none;
        }

        .headerlitooleulsubitem_gray>li,
        .headerlitooleulsubitem_red>li {
            height: 45px;
            background-color: White;
            padding: 0px 10px;
            border-bottom: 1px solid #E4ECF3;
            font-size: 14px;
            line-height: 26px;
        }

        .headerlitoolelisubitemtitle_gray {
            height: 35px !important;
            line-height: 35px !important;
            background-color: #ECF2F7 !important;
            margin: 0px !important;
            color: #8090A0 !important;
            font-size: 14px;
            font-weight: bold;
            border-bottom: 1px solid #BCD4E5 !important;
        }

        .headerlitoolelisubitemtitle_red {
            height: 35px !important;
            line-height: 35px !important;
            background-color: #F7ECF2 !important;
            margin: 0px !important;
            color: #B471A0 !important;
            font-size: 14px;
            font-weight: bold;
            border-bottom: 1px solid #E5BCD4 !important;
        }

        .headerlitooleulsubitem_gray>li:hover {
            background-Color: #F4F9FC;
        }

        .headerlitooleulsubitem_red>li:hover {
            background-color: #FCF4F9;
        }

        .ulsubitemitems>li {
            float: left;
            height: 20px;
            font-size: 13px;
            font-weight: normal !important;
            color: #555 !important;
        }

        .ulsubitemitems>li:last-child {
            clear: both;
            width: 100%;
            height: 10px;
            margin-top: 8px;
            background-color: #DADADA;
        }

        .headerlitools_info {
            background-color: #0a318d;
            height: 45px;
            padding: 0px 10px;
            width: 135px;
        }

        /*.headeruserface {*/
        /*    background-image: url('/content/resources/images/logo.png');*/
        /*    width: 40px;*/
        /*    height: 40px;*/
        /*    background-color: white;*/
        /*    margin: 2px 10px 2px 2px;*/
        /*    border-radius: 20px;*/
        /*    float: left;*/
        /*}*/

        .headerlitools_ulinfo {
            background-Color: white;
            border-left: 1px solid #D1D1D1;
            border-right: 1px solid #D1D1D1;
            border-bottom: 1px solid #D1D1D1;
            box-shadow: 0px 0px 5px #D1D1D1;
            width: 160px;
            margin-left: -20px;
            color: Black;
            display: none;
        }

        .headerlitools_ulinfo>li {
            height: 35px;
            background-color: White;
            padding: 0px 10px;
            font-size: 14px;
            line-height: 36px;
        }

        .headerlitools_ulinfo>li:hover {
            background-Color: #FEE188;
        }

        .dvcontent {
            padding: 0px 20px;
            margin: 45px auto 0px auto;
            overflow: auto;
        }

        .dvpagerecord {
            padding: 6px 12px;
            background-color: #EAEFF2;
            color: #2283C5;
            float: left;
            border: 1px solid #D9D9D9;
            text-decoration: underline;
            font-size: 14px;
            cursor: pointer;
        }

        .dvpagerecord:hover {
            cursor: pointer;
        }

        .dvpagerecord:hover i {
            text-decoration: underline;
        }

        .ulpageRecord {
            max-width: 165px;
            float: left;
            white-space: nowrap;
            overflow: hidden;
            margin: 0px;
            padding: 0px;
        }

        .ulpageRecord li {
            margin: 0px;
            padding: 6px 12px;
            background-color: #EAEFF2;
            color: #2283C5;
            display: inline-block;
            font-size: 14px;
            border: 1px solid #D9D9D9;
        }

        .ulpageRecord li:hover {
            text-decoration: underline;
            cursor: pointer;
        }

        .currentPage {
            background-color: #2468a9 !important;
            color: white !important;
        }

        #warn {
            width: 300px;
        }

        #warn tr {
            width: 300px;
            height: 20px;
        }

        #warn tr td {
            width: 90px;
            height: 20px;
            text-align: center;
        }

        iframe {
            border: none;
        }
        #lalast{
        margin:6px -84px 0;
        }
        #annniu{
            margin:5px 30px 0px 0px ;
        }
    </style>
    <link href="../../css/zy.menu.css" rel="stylesheet" />
</head>

<body>
<div class="dvheader">
    <div class="dvheadertools" >
        <span class="headerspantitle">医院管理系统</span>
        <ul class="headerultools" id="annniu">
            <div class="btn-group">
                <button type="button" class="btn btn-primary  dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    管理 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu"  id="lalast">
                    <li role="separator" class="divider"></li>
                    <li><a href="/HospitalsServlet?transmits=Hospout">退出登录</a></li>
                </ul>
            </div>
            </li>
        </ul>
    </div>
</div>
<div class="dvcontent">

    <ul class="ulleftmenu" style="border-right: 1px solid #ddd;">

        <li class="limenuitem">
            <i class="icon-cog menuicon"></i>系统菜单<b class="arrow icon-angle-down arrow-down"></b>
            <ul class="ulleftsubitems">
                <a href="/HospitalsServlet?transmits=indexHospitaltaffS" target="right" >
                    <li>主治医生管理</li>
                </a>
                <a href="/HospitalsServlet?transmits=selectNurse" target="right">
                    <li>护士管理</li>
                </a>
                <a href="/HospitalsServlet?transmits=indexPatients" target="right">
                    <li>病人管理</li>
                </a>
<%--                <a href="" target="right">--%>
<%--                    <li>请假管理</li>--%>
<%--                </a>--%>
                <a href="/HospitalsServlet?transmits=indexDarg" target="right">
                    <li>药品管理</li>
                </a>
                <a href="/HospitalsServlet?transmits=indexThesection" target="right">
                    <li>科室管理</li>
                </a>
                <a href="/HospitalsServlet?transmits=updatePaw" target="right"><li >修改密码</li></a>
            </ul>
        </li>
    </ul>
    <div style="position: absolute; left: 191px; right: 20px; ">
        <iframe src="/HospitalsServlet?transmits=indexHospitaltaffS" scrolling="no" width="100%" height="898px" name="right" border="none"></iframe>
    </div>
</div>


<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
</body>

</body>
</html>