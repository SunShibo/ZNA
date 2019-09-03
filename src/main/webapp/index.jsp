<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/8/24
  Time: 10:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<body>
    <h1>Hello Word!</h1>
    <form method="post" action="/image/uploadImg" enctype="multipart/form-data">
        选择一个文件:
        <input type="file" name="file" />
        <br/><br/>
        <input type="submit" value="上传" />
    </form>
</body>
</html>
