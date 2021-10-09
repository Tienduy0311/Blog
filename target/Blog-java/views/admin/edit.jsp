<%--
  Created by IntelliJ IDEA.
  User: ThamTT
  Date: 8/26/2021
  Time: 2:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
    <main>
        <div class="container-fluid px-4">
            <h1 class="mt-4">Thêm mới</h1>
            <ol class="breadcrumb mb-4">
                <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                <li class="breadcrumb-item active">Add New</li>
            </ol>
            <div class="card mb-4 p-5">
                <div class="mb-3">
                    <label for="category" class="form-label"><b>Danh mục</b></label>
                    <select class="form-select" aria-label="Default select example" id="category">
                        <option selected>Open this select menu</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                    </select>
                </div>
                <div class="mb-3">
                    <label for="title" class="form-label"><b>Tiêu đề</b></label>
                    <input type="text" class="form-control" id="title" placeholder="VD: bài viết số 1">
                </div>
                <div class="mb-3">
                    <label for="thumbnail" class="form-label"><b>Ảnh đại diện</b></label>
                    <input type="text" class="form-control" id="thumbnail" placeholder="VD: ảnh số 1">
                </div>
                <div class="mb-3">
                    <label for="short_description" class="form-label"><b>Mô tả ngắn</b></label>
                    <textarea class="form-control" placeholder="Leave a comment here" id="short_description" style="height: 100px"></textarea>
                </div>
                <div class="mb-3">
                    <label for="content" class="form-label"><b>Nội dung</b></label>
                    <input type="text" class="form-control" id="content">
                </div>
            </div>
        </div>
    </main>
</body>
</html>
