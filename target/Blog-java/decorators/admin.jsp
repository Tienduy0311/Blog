<%--
  Created by IntelliJ IDEA.
  User: ThamTT
  Date: 8/25/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title><dec:title default="Trang chủ" /></title>
    <link href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css" rel="stylesheet" />
    <link rel="stylesheet" href="<c:url value="/template/admin/css/styles.css" />"/>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js" crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script src="<c:url value="/template/paging/jquery.twbsPagination.js"/>" type="text/javascript" ></script>
</head>
    <body class="sb-nav-fixed">
        <%-- header start --%>
        <%@include file="/common/admin/header.jsp"%>
        <%-- header end --%>
        <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <%-- menu start --%>
                <%@include file="/common/admin/menu.jsp"%>
                <%-- menu end --%>
            </div>
            <div id="layoutSidenav_content">
                <%-- main start --%>
                <dec:body />
                <%-- main end --%>
                <%-- footer start --%>
                <%@include file="/common/admin/footer.jsp"%>
                <%-- footer end --%>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="<c:url value="/template/admin/js/scripts.js" />"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>
        <script src="<c:url value="/template/admin/assets/demo/chart-area-demo.js"/>"></script>
        <script src="<c:url value="/template/admin/assets/demo/chart-bar-demo.js"/>"></script>
        <script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest" crossorigin="anonymous"></script>
        <script src="<c:url value="/template/admin/js/datatables-simple-demo.js"/>"></script>

    </body>
</html>
