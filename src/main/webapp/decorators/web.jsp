<%--
  Created by IntelliJ IDEA.
  User: DuyNT
  Date: 8/25/2021
  Time: 4:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title><dec:title default="Trang chủ" /></title>
    <link rel="icon" type="image/x-icon" href="<c:url value='/template/web/assets/favicon.ico'/>" />
    <link rel="stylesheet" href="<c:url value='/template/web/css/styles.css'/>" />
    <link rel="stylesheet" href="<c:url value="/template/web/css/home.css" />" />
</head>
<body>
<%--    header--%>
    <%@ include file="/common/web/header.jsp" %>
<%--    header--%>
    <div class="container mt-6">
        <dec:body/>
    </div>

<%--    footer--%>
    <%@ include file="/common/web/footer.jsp" %>
<%--    footer--%>

<!-- Bootstrap core JS-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
    <script src="<c:url value="/template/web/js/scripts.js"/>"></script>
</body>
</html>