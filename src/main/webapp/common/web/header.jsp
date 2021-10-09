<%--
  Created by IntelliJ IDEA.
  User: ThamTT
  Date: 8/25/2021
  Time: 4:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Responsive navbar-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container">
        <a class="navbar-brand fw-bold fs-7" href="#!">Dcoder</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-5 mb-2 mb-lg-0">
                <li class="nav-item"><a class="nav-link color-1" href="">Trang chủ</a></li>
                <li class="nav-item"><a class="nav-link color-1" href="">Danh mục</a></li>
                <li class="nav-item"><a class="nav-link color-1" href="">Giới thiệu</a></li>
            </ul>
            <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                <c:if test="${USER.userName == null}" >
                    <li class="nav-item"><a class="nav-link color-1" href="<c:url value="/login?action=login"/>">Đăng nhập</a></li>
                    <span class="pd-1 color-1">|</span>
                    <li class="nav-item"><a class="nav-link color-1" href="">Đăng ký</a></li>
                </c:if>
                <c:if test="${USER.userName != null}" >
                    <li class="nav-item"><a class="nav-link color-1">Hi, ${USER.userName}</a></li>|
                    <li class="nav-item"><a class="nav-link color-1" href="<c:url value="/logout?action=logout" />">Đăng xuất</a></li>
                </c:if>
            </ul>
        </div>
    </div>
</nav>
