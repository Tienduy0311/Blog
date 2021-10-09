<%--
  Created by IntelliJ IDEA.
  User: ThamTT
  Date: 9/5/2021
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <div id="layoutAuthentication">
        <div id="layoutAuthentication_content">
            <main>
                <div class="container">
                    <div class="row justify-content-center">
                        <div class="col-lg-5">
                            <div class="card shadow-lg border-0 rounded-lg mt-5">
                                <div class="card-header"><h3 class="text-center font-weight-light my-4">Dcoder</h3></div>
                                <div class="card-body">
                                    <form action="<c:url value="/login?action=login" />" method="post">
                                        <c:if test="${error != null}" >
                                            <div class="alert alert-danger">
                                                <strong>Danger!</strong> ${error}
                                            </div>
                                        </c:if>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="username" type="text" placeholder="Tên đang nhập" name="userName"/>
                                            <label for="username">Tên đăng nhập</label>
                                        </div>
                                        <div class="form-floating mb-3">
                                            <input class="form-control" id="inputPassword" type="password" placeholder="Mật khẩu" name="password" />
                                            <label for="inputPassword">Mật khẩu</label>
                                        </div>
                                        <div class="form-check mb-3">
                                            <input class="form-check-input" id="inputRememberPassword" type="checkbox" value="" />
                                            <label class="form-check-label" for="inputRememberPassword">Nhớ mật khẩu</label>
                                        </div>
                                        <div class="d-flex align-items-center justify-content-between mt-4 mb-0">
                                            <a class="small" href="password.html">Quên mật khẩu?</a>
                                            <button class="btn btn-primary" type="submit">Đăng nhập</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </main>
        </div>
    </div>
</body>
</html>
