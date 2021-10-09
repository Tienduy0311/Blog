
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Posts List</title>
</head>
<body>
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Posts</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                <li class="breadcrumb-item active">Posts</li>
            </ol>
            <div class="card mb-4">
                <div class="card-header">
                    <i class="fas fa-table me-1"></i>
                    DataTable Example
                </div>
                <form class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 mt-3">
                    <div class="input-group">
                        <a class="pe-3" href="<c:url value="/admin-add-posts?type=add"/>"><img title="thêm bài viết" class="w-42" src="<c:url value="/template/img/icon_add_1.jpg"/>"></a>
                        <input class="form-control" type="text" placeholder="Search for..." aria-label="Search for..." aria-describedby="btnNavbarSearch" />
                        <button class="btn btn-primary" id="btnNavbarSearch" type="button"><i class="fas fa-search"></i></button>
                    </div>
                </form>
                <div class="card-body">
                    <form action="<c:url value="/admin-posts"/>" method="get" name="nextPage">
                        <table class="table table-bordered table-hover">
                            <thead>
                                <tr>
                                    <th style="width: 50%">Title</th>
                                    <th style="width: 20%">Author</th>
                                    <th style="width: 10%">Comment</th>
                                    <th style="width: 20%">Create Date</th>
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="item" items="${modelPosts.getListModel()}">
                                <tr>
                                    <td><c:out value="${item.getTitle()}"/></td>
                                    <td><c:out value="${item.getCreateBy()}"/></td>
                                    <td>1</td>
                                    <td><c:out value="${item.getCreateDate()}"/></td>
                                </tr>
                            </c:forEach>
                            <input type="hidden" value="" name="startPage"/>
                            <input type="hidden" value="" name="rowOfPage"/>
                            </tbody>
                        </table>
                    </form>
                    <ul class="pagination float-end" id="pagination"></ul>
                </div>
            </div>
        </div>
    </main>
    <script type="text/javascript">
        var totalPage = ${modelPosts.totalPage};
        var startPage = ${modelPosts.startPage};
        var rowOfPage = 3;
        $(function () {
            window.pagObj = $('#pagination').twbsPagination({
                totalPages: totalPage,
                visiblePages: 5,
                startPage: startPage,
                onPageClick: function (event, page) {
                    if (startPage != page) {
                        $("input[name='startPage']").val(page);
                        $("input[name='rowOfPage']").val(rowOfPage);
                        $("form[name='nextPage']").submit();
                    }
                }
            }).on('page', function (event, page) {
                console.info(page + ' (from event listening)');
            });
        });
    </script>
</body>
</html>
