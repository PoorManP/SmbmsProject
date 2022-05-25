<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<%@include file="/jsp/common/head.jsp" %>

<link href="jquery/bootstrap_3.3.0/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="jquery/bootstrap-datetimepicker-master/css/bootstrap-datetimepicker.min.css" type="text/css"
      rel="stylesheet"/>

<script type="text/javascript" src="jquery/jquery-1.11.1-min.js"></script>
<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="jquery/bootstrap_3.3.0/js/bootstrap.min.js"></script>--%>
<script type="text/javascript" src="jquery/bootstrap-datetimepicker-master/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript"
        src="jquery/bootstrap-datetimepicker-master/locale/bootstrap-datetimepicker.zh-CN.js"></script>

<link rel="stylesheet" type="text/css" href="jquery/bs_pagination/jquery.bs_pagination.min.css">
<script type="text/javascript" src="jquery/bs_pagination/jquery.bs_pagination.min.js"></script>
<script type="text/javascript" src="jquery/bs_pagination/en.js"></script>
<script>
    $(function () {

        $(".time").datetimepicker({
            minView: "month",
            language: 'zh-CN',
            format: 'yyyy-mm-dd',
            autoclose: true,
            todayBtn: true,
            pickerPosition: "bottom-left"
        });
        pageList(1, 6)

        $("#submitBtn").keydown(function (even) {
            if (even.keyCode == 13) {
                pageList(1, 6)
            }
        })
        $("#submitBtn").click(function () {
            pageList(1, 6);
        })


        $("#updateBtn").click(function () {
            if (confirm("确认修改用户信息!")) {
                $.ajax({
                    url: "updateUser.do",
                    dataType: "json",
                    type: "post",
                    data: {
                        "id": $("#editId").val(),
                        "birthDay": $("#editBirthDay").val(),
                        "gender": $("#editGender").val(),
                        "phone": $("#editPhone").val(),
                        "userCode": $("#editUserCode").val(),
                        "userName": $("#editUserName").val(),
                        "userRole": $("#editUserRole").val()
                    },
                    success: function (response) {
                        if (response.success) {
                            alert("更新用户成功")

                            $("#editUserForm")[0].reset()

                            pageList(1,
                                $("#userPageBarPage").bs_pagination('getOption', 'rowsPerPage'));

                            $("#editUserModal").modal("hide")


                        } else {
                            alert("更新用户失败")
                        }
                    }
                })
            }
        })

    })


    function editUser(id) {

        $.ajax({
            url: "userInfo.do",
            type: "get",
            dataType: "json",
            data: {
                "id": id
            },
            success: function (response) {
                $("#editId").val(response.id)
                $("#editBirthDay").val(response.birthDay)
                $("#editGender").val(response.gender)
                $("#editPhone").val(response.phone)
                $("#editUserCode").val(response.userCode)
                $("#editUserName").val(response.userName)
                $("#editUserRole").val(response.userRole)

                $("#editUserModal").modal("show")
            }
        })

    }

    function pageList(pageNo, pageSize) {
        //
        $.ajax({

            url: "pageList.do",
            type: "get",
            data: {
                "pageNo": pageNo,
                "pageSize": pageSize,
                "name": $.trim($("#queryname").val()),
                "queryUserRole": $.trim($("#queryUserRole").val())
            },
            dataType: "json",
            success: function (response) {

                var html = "";
                $.each(response.dataList, function (i, n) {
                    html += '<tr>'
                    html += '<td>'
                    html += '<span>' + n.userCode + '</span>'
                    html += '</td>'
                    html += '<td>'
                    html += '<span>' + n.userName + '</span>'
                    html += '</td>'
                    html += '<td>'
                    html += '<span>' + n.gender + '</span>'
                    html += '</td>'
                    html += '<td>'
                    html += '<span>' + n.age + '</span>'
                    html += '</td>'
                    html += '<td>'
                    html += '<span>' + n.phone + '</span>'
                    html += '</td>'
                    html += '<td>'
                    html += '<span>' + n.userRoleName + '</span>'
                    html += '</td>'
                    html += '<td>'

                    html += '<span><a class="viewUser" href="javascript:;" userid=' + n.id + ' username=' + n.userName + '><img src="statics/images/read.png" alt="查看" title="查看"/></a></span>'
                    html += '<span><a class="modifyUser" href="javascript:;" userid=' + n.id + ' username=' + n.userName + '><img src="statics/images/xiugai.png" onclick="editUser(' + n.id + ')" alt="修改" title="修改"/></a></span>'
                    html += '<span><a class="deleteUser" href="javascript:;"><img src="statics/images/schu.png" alt="删除" title="删除" onclick="deleUser(' + n.id + ')"/></a></span>'

                });


                $("#tbody").html(html);

                var totalPages = response.total % pageSize == 0 ? response.total / pageSize : parseInt(response.total / pageSize) + 1
                //数据处理完毕后 结合分布插件

                $('#userPageBarPage').bs_pagination({
                    currentPage: pageNo, // 页码
                    rowsPerPage: pageSize, // 每页显示的记录条数
                    maxRowsPerPage: 20, // 每页最多显示的记录条数
                    totalPages: totalPages, // 总页数
                    totalRows: response.total, // 总记录条数

                    visiblePageLinks: 3, // 显示几个卡片

                    showGoToPage: true,
                    showRowsPerPage: true,
                    showRowsInfo: true,
                    showRowsDefaultInfo: true,

                    onChangePage: function (event, data) {
                        pageList(data.currentPage, data.rowsPerPage);
                    }
                })

            }
        });
    }

    function deleUser(id, userName) {

        if (confirm('你确定要删除' + userName + '用户吗?')) {
            $.ajax({
                url: "delUser.do",
                dataType: "json",
                type: "get",
                data: {
                    "id": id
                },
                success: function (response) {
                    if (response.success) {
                        pageList(1
                            , $("#userPageBarPage").bs_pagination('getOption', 'rowsPerPage'));
                    } else {
                        alert("删除失败")
                    }

                }
            })
        }
    }
</script>
<div class="right">
    <div class="location">
        <strong>你现在所在的位置是:</strong>
        <span>用户管理页面</span>
    </div>
    <div class="search">
        <form method="post" action="" class="text-center">
            <input name="method" value="query" class="input-text" type="hidden">
            <span>用户名：</span>
            <input name="queryname" id="queryname" class="input-text" type="text">
            <span>用户角色：</span>
            <select name="queryUserRole" id="queryUserRole">
                <option value="">--请选择--</option>
                <c:forEach var="r" items="${roleList}">
                    <option
                            value="${r.id}">${r.roleName}</option>
                </c:forEach>
            </select>

            <input value="查 询" type="button" id="submitBtn">
            <a href="jsp/useradd.jsp">添加用户</a>
        </form>
    </div>
    <!--用户-->
    <table class="providerTable" cellpadding="0" cellspacing="0">
        <tr class="firstTr">
            <th width="10%" class="text-center">用户编码</th>
            <th width="20%" class="text-center">用户名称</th>
            <th width="10%" class="text-center">性别</th>
            <th width="10%" class="text-center">年龄</th>
            <th width="10%" class="text-center">电话</th>
            <th width="10%" class="text-center">用户角色</th>
            <th width="30%" class="text-center">操作</th>
        </tr>
        <tbody id="tbody">
        <%--        <c:forEach var="user" items="${userList }" varStatus="status">--%>
        <%--        </c:forEach>--%>

        </tbody>

    </table>
    <input type="hidden" id="totalPageCount" value="${totalPageCount}"/>
    <div class="page-bar" id="userPageBarPage">

    </div>
</div>
</section>
<div class="modal fade" id="editUserModal" role="dialog">
    <div class="modal-dialog" role="document" style="width: 85%;">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">
                    <span aria-hidden="true">×</span>
                </button>
                <h4 class="modal-title" id="myModalLabel2">修改用户页面</h4>
            </div>
            <div class="modal-body">

                <form class="form-horizontal" role="form" id="editUserForm">

                    <input type="hidden" name="" id="editId">
                    <div class="form-group">
                        <label for="edit-marketActivityOwner" class="col-sm-2 control-label">用户编码<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="editUserCode" value="">
                        </div>
                        <label for="edit-marketActivityName" class="col-sm-2 control-label">用户名称<span
                                style="font-size: 15px; color: red;">*</span></label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="editUserName" value="">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit-startTime" class="col-sm-2 control-label">性别</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select name="gender" form-control id="editGender" style="width: 100%">
                                <option value="1" selected="selected">男</option>
                                <option value="2">女</option>
                            </select>
                        </div>
                        <label for="edit-endTime" class="col-sm-2 control-label">出生日期</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control time" id="editBirthDay" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-cost" class="col-sm-2 control-label">电话</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <input type="text" class="form-control" id="editPhone" value="">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="edit-describe" class="col-sm-2 control-label">描述</label>
                        <div class="col-sm-10" style="width: 300px;">
                            <select name="queryUserRole" class="form-control" id="editUserRole">
                                <option value="">--请选择--</option>
                                <c:forEach var="r" items="${roleList}">
                                    <option
                                            value="${r.id}">${r.roleName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>

                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" data-dismiss="modal" id="updateBtn">更新</button>
            </div>
        </div>
    </div>
</div>

<!--点击删除按钮后弹出的页面-->

<%@include file="/jsp/common/foot.jsp" %>
<script type="text/javascript" src="${pageContext.request.contextPath }/statics/js/userlist.js"></script>
