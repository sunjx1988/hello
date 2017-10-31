<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>login</title>
    <script type="text/javascript" src="/js/jquery.min.js"></script>
    <script type="text/javascript" src="/js/shiro-login.js"></script>
</head>
<body>
<h1>这里是登录页</h1>
<br>
<a href="/authorized">需要登录的页面</a>&nbsp;
<a href="/unauthorized">不需要登录页面</a>&nbsp;
<a href="/role">需要角色页面</a>&nbsp;
<a href="/menu">需要菜单权限页面</a>&nbsp;
<shiro:guest>
    <a id="login" href="javascript:;">快捷登录</a>&nbsp;
</shiro:guest>
<shiro:user>
    <shiro:principal />&nbsp;<a id="logout" href="javascript:;">登出</a>&nbsp;
</shiro:user>
</body>
</html>
