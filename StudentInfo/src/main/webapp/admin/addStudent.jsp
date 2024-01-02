<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon"/>
    <meta charset="UTF-8">
    <title>学生信息管理系统</title>
    <script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
    <!-- Loading Bootstrap -->
    <link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
    <!-- Loading Flat UI Pro -->
    <link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
    <!-- Loading Flat UI JS -->
    <script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>
    <script type="text/javascript">
        $(document).ready(
            function () {
                $("#sid").change(
                    function () {
                        $.post("/StudentInfo/AjaxHandler/existSid?sid="
                            + $("#sid").val(), function (data, status) {
                            $("#countsid").html(data);
                        })

                    })

            })

    </script>
    <script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script>
    <link href="/StudentInfo/utils/css/animate.css" rel="stylesheet">
</head>

<body>
<div id="particles-js">
    <canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas>
</div>
<jsp:include page="adminLeft.jsp"/>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h5>添加学生</h5>
            <form action="/StudentInfo/AdminHandler/addStudent" method="post" name="form1">
                <div class="row">
                    <div class="col-md-6">
                        <h6>学号</h6>
                        <input type="text" name="sid" id="sid" class="form-control"
                               oninput="value=value.replace(/[^\d]/g,'')" maxlength="12"></input>
                        <span id="countsid" style="color: #ff0000;"></span>
                        <h6>姓名</h6>
                        <input type="text" name="sname" class="form-control"
                               onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4"></input>
                        <h6>身份证号</h6>
                        <input type="text" name="sidcard" class="form-control"
                               oninput="value=value.replace(/[^\d]/g,'')" maxlength="16"></input>
                        <h6>性别</h6>

                        <label class="radio" for="radio1"> <input type="radio"
                                                                  name="ssex" value="男" id="radio1" data-toggle="radio"
                                                                  class="custom-radio"> <span class="icons"> <span
                                class="icon-unchecked"></span> <span class="icon-checked"></span>
							</span> <font style="vertical-align: inherit;"> <font
                                style="vertical-align: inherit;"> 男 </font>
                        </font>
                        </label> <label class="radio" for="radio2"> <input type="radio"
                                                                           name="ssex" value="女" id="radio2"
                                                                           data-toggle="radio"
                                                                           class="custom-radio"> <span
                            class="icons"> <span
                            class="icon-unchecked"></span> <span class="icon-checked"></span>
							</span> <font style="vertical-align: inherit;"> <font
                            style="vertical-align: inherit;"> 女 </font>
                    </font>
                    </label>

                        <h6>密&nbsp;&nbsp;码</h6>
                        <input type="password" name="spassword" class="form-control"
                               onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"/>
                    </div>
                    <div class="col-md-6">
                        <h6>年龄</h6>
                        <input type="text" name="sage" class="form-control" maxlength="2"></input>


                        <h6>专业</h6>
                        <select name="profession"
                                class="form-control select select-primary select-block mbl" id="belongcoll">
                            <option value="">-请选择学院-</option>
                        </select>

                        <h6>学院</h6>
                        <select name="college"
                                class="form-control select select-primary select-block mbl" id="belongpro">
                            <option value="">-请选择专业-</option>
                        </select>

                        <h6>班级</h6>
                        <select name="classr"
                                class="form-control select select-primary select-block mbl" id="belongcla">
                            <option value="">-请选择班级-</option>
                        </select>

                    </div>
                    <div class="col-md-12">
                        <br> <input type="submit"
                                    class="btn btn-primary btn-wide login-btn" value="添加"/>
                    </div>
                </div>
            </form>

        </div>
    </div>
</div>

<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script>
<script src="/StudentInfo/utils/scripts/bganimation.js"></script>


<script type="text/javascript">

    $("form").submit(function () {
        //当表单提交的时候，对字段验证，并根据需要放出提示
        if ($.trim($("#belongcoll").val()) == "") {
            alert("学院不能为空");
            return false;//终止表单提交

        } else if ($.trim($("#belongpro").val()) == "") {
            alert("专业不能为空");
            return false;//终止表单提交

        } else if ($.trim($("#belongcla").val()) == "") {
            alert("班级不能为空");
            return false;//终止表单提交

        }
    });


    var arr_belongcoll = ["计算机学院", "建筑学院", "外国语学院", "人文学院"];
    var arr_belongpro = [
        ["网络工程", "软件工程", "物联网", "信息管理"],
        ['土木工程', '测绘工程', '工程造价', '城市规划'],
        ['英语', '日语', '俄语', '西班牙语'],
        ['汉语言', '历史', '新闻', '网络新媒体']
    ];
    var arr_belongcla = [
        [
            ["网络B201", "网络B202", "网络B211", "网络B212", "网络B221", "网络B222"],
            ["软件B201", "软件B202", "软件B211", "软件B212", "软件B221", "软件B222"],
            ["物联B201", "物联B202", "物联B211", "物联B212", "物联B221", "物联B222"],
            ["信管B201", "信管B202", "信管B211", "信管B212", "信管B221", "信管B222"]

        ],
        [
            ["土木B201", "土木B202", "土木B211", "土木B212", "土木B221", "土木B222"],
            ["测绘B201", "测绘B202", "测绘B211", "测绘B212", "测绘B221", "测绘B222"],
            ["造价B201", "造价B202", "造价B211", "造价B212", "造价B221", "造价B222"],
            ["规划B201", "规划B202", "规划B211", "规划B212", "规划B221", "规划B222"]

        ],
        [
            ["英语B201", "英语B202", "英语B211", "英语B212", "英语B221", "英语B222"],
            ["日语B201", "日语B202", "日语B211", "日语B212", "日语B221", "日语B222"],
            ["俄语B201", "俄语B202", "俄语B211", "俄语B212", "俄语B221", "俄语B222"],
            ["牙语B201", "牙语B202", "牙语B211", "牙语B212", "牙语B221", "牙语B222"]

        ],
        [
			["汉语B201","汉语B202","汉语B211","汉语B212","汉语B221","汉语B222"],
			["历史B201","历史B202","历史B211","历史B212","历史B221","历史B222"],
			["新闻B201","新闻B202","新闻B211","新闻B212","新闻B221","新闻B222"],
			["网媒B201","网媒B202","网媒B211","网媒B212","网媒B221","网媒B222"]

		]
    ];

    var ocoll = document.getElementById("belongcoll");
    var opro = document.getElementById("belongpro");
    var ocla = document.getElementById("belongcla");


    var quanju_arr;//创建一个全局对象，用于存储一个中间数组

    function input_arr(arr, event) {//封装一个函数，用于向下拉栏中添加元素
        for (var i = 0; i < arr.length; i++) {//下拉栏内的元素来源于数组中的元素，遍历数组
            var option = new Option(arr[i], i);//创建Option对象（这个O要大写），存入值
            event.appendChild(option);//把option添加到event对象的末尾
        }
    }

    input_arr(arr_belongcoll, ocoll);//调用,给省下拉栏添元素

    ocoll.onchange = function () {//给下拉栏绑定事件（当下拉栏元素改变时执行）
        opro.options.length = 1;//当省下拉栏改变时，清空市的下拉栏内元素
        ocla.options.length = 1;//当省下拉栏改变时，清空县的下拉栏内元素
        var index = this.value;//每一个option标签都有一个value值索引，获取索引，用于数组中元素的选择
        var arr_pro_next = arr_belongpro[index];//获取当前选择省的市元素并赋给一个数组
        quanju_arr = arr_belongcla[index];//获取当前选择省中市的县元素并赋给定义的中间数组
        input_arr(arr_pro_next, opro);//调用,给市下拉栏添元素
    }

    opro.onchange = function () {
        ocla.options.length = 1;
        var index = this.value;
        var arr_cla_next = quanju_arr[index];
        input_arr(arr_cla_next, ocla);//调用,给县下拉栏添元素
    }


</script>
<script>
    $("select").select2({
        dropdownCssClass: 'dropdown-inverse'
    });
</script>
</body>
</html>