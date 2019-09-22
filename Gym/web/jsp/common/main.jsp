<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 08.07.2019
  Time: 11:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<fmt:bundle basename="page_content">
    <fmt:message key="main.title" var="title"/>
    <fmt:message key="page.content.info" var="info"/>
    <fmt:message key="page.content.news" var="news"/>
    <fmt:message key="page.content.promotion" var="promotion"/>
</fmt:bundle>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    <title>${pageScope.title}</title>
</head>
<body class="page">
<tag:userMenu/>
<p class="error">${requestScope.message}</p>

<div id="carouselControls" class="carousel slide clearfix" data-ride="carousel">
    <div class="carousel-inner">
        <div class="carousel-item active" data-interval="5000">
            <div class="row no-gutters">
                <div class="col-lg col-md-12 col-sm-12">
                    <img class="main_img" src="${pageContext.request.contextPath}/images/images.jpg" alt="">
                </div>
                <div class="col-lg col-md-12 col-sm-12 text-theme">
                    <p>
                        ${pageScope.info}
                    </p>
                </div>
            </div>
        </div>
        <div class="carousel-item" data-interval="5000">
            <div class="row no-gutters">
                <div class="col-lg col-md-12 col-sm-12">
                    <img class="main_img" src="${pageContext.request.contextPath}/images/workout-tips.jpg" alt="">
                </div>
                <div class="col-lg col-md-12 col-sm-12 text-theme">
                    <p>
                        ${pageScope.news}
                    </p>
                </div>
            </div>
        </div>
        <div class="carousel-item wrapper_content-item clearfix" data-interval="5000">
            <div class="row no-gutters">
                <div class="col-lg col-md-12 col-sm-12">
                    <img class="main_img" src="${pageContext.request.contextPath}/images/girl.jpg" alt="">
                </div>
                <div class="col-lg col-md-12 col-sm-12 text-theme">
                    <p>
                        ${pageScope.promotion}
                    </p>
                </div>
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselControls" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselControls" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
</div>

<footer class="footer">
    <p>
        <span><i class="fa fa-mobile" aria-hidden="true"></i> +375 (33)6340558</span>
    </p>
</footer>
</body>
</html>
