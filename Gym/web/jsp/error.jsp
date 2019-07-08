<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.07.2019
  Time: 11:00
  To change this template use File | Settings | File Templates.
--%>


<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>${pageScope.title}</title>
</head>
<body class="page">
<div class="error_wrapper">

    <p> ${pageContext.errorData.requestURI} is failed</p>
    <p>${pageScope.servlet_message} ${pageContext.errorData.servletName}</p>
    <p>${pageScope.status_message} ${pageContext.errorData.statusCode}</p>
    <p>${pageScope.exception_message} ${pageContext.errorData.throwable}</p>
</div>
</body>
</html>