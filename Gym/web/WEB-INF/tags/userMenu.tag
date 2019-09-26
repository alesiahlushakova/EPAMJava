<%@tag pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>


<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<fmt:bundle basename="page_content">
    <fmt:message key="menu.title" var="title"/>
    <fmt:message key="menu.hello" var="hello"/>
    <fmt:message key="menu.hello_guest" var="hello_guest"/>
    <fmt:message key="menu.login" var="login"/>
    <fmt:message key="menu.register" var="register"/>
    <fmt:message key="menu.logout" var="logout"/>
    <fmt:message key="menu.create_training_program" var="create_training_program"/>
    <fmt:message key="menu.create_exercise" var="create_exercise"/>
    <fmt:message key="menu.show_personal_clients" var="show_personal_clients"/>
    <fmt:message key="menu.show_clients" var="show_clients"/>
    <fmt:message key="menu.find_client" var="find_client"/>
    <fmt:message key="menu.orders_history" var="orders_history"/>
    <fmt:message key="menu.my_training_program" var="my_training_program"/>
    <fmt:message key="menu.make_order" var="make_order"/>
    <fmt:message key="menu.change" var="change"/>
    <fmt:message key="menu.register_coach" var="register_coach"/>
    <fmt:message key="menu.language" var="language"/>
    <fmt:message key="menu.edit" var="edit"/>
</fmt:bundle>

<header class="header">
    <div class="row">
        <div class="col-2">
            <div class="change_level">
                <ul>
                    <li>${pageScope.language} </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=ru">RU</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=by">BY</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=en">EN</a>
                    </li>
                </ul>
            </div>
        </div>
        <div class="col-8">
            <h1 class="top">${pageScope.title}</h1>
        </div>
        <div class="col-2">
            <div class="hello_message">
                <c:choose>
                    <c:when test="${sessionScope.user == null}">
                        <span class="hello_text">${pageScope.hello_guest}</span>
                        <a class="logout_a"
                           href="${pageContext.request.contextPath}/jsp/common/login.jsp">${pageScope.login}</a>
                        <a class="register_login_a"
                           href="${pageContext.request.contextPath}/jsp/common/register.jsp">${pageScope.register}</a>
                    </c:when>
                    <c:otherwise>
                        <img id="foo" width="30" height="30" src="${pageContext.request.contextPath}/imageServlet" onerror="this.src='${pageContext.request.contextPath}/images/avatar.jpg';" >
                        <span class="hello_text">${pageScope.hello} ${sessionScope.user.firstName} ${sessionScope.user.lastName}</span>
                        <span class="hello_text"><a class="logout_a" href="${pageContext.request.contextPath}/jsp/common/edit_user.jsp">${pageScope.edit}</a> </span>
                        <a class="register_login_a"
                           href="${pageContext.request.contextPath}/controller?command=common_logout">${pageScope.logout}</a>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
</header>

<div class="user_menu">
    <ul>
        <c:if test="${sessionScope.user != null}">
            <li><a href="${pageContext.request.contextPath}/jsp/common/main.jsp"><i class="fa fa-home"
                                                                                    aria-hidden="true"></i></a></li>
            <c:choose>
                <c:when test="${sessionScope.user.userRole == 'COACH'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=coach_prepare_program_creation">${pageScope.create_training_program}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/jsp/coach/create_exercise.jsp">${pageScope.create_exercise}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=coach_show_personal_clients">${pageScope.show_personal_clients}</a>
                    </li>
                </c:when>
                <c:when test="${sessionScope.user.userRole == 'ADMIN'}">
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=admin_show_all_clients">${pageScope.show_clients}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=admin_register_coach">${pageScope.register_coach}</a>
                    </li>
                    <li>
                        <form id="find" name="FindForm" method="POST"
                              action="${pageContext.request.contextPath}/controller">
                            <input type="hidden" name="command" value="admin_find_client_by_name"/>
                            <label>${pageScope.find_client} <input type="text" name="name" value=""/></label>
                            <button type="submit"><i class="fa fa-search" aria-hidden="true"></i></button>
                        </form>
                    </li>
                </c:when>
                <c:otherwise>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=special_show_client_subscriptions&client_id=${sessionScope.user.id}">${pageScope.orders_history}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=special_show_client_program&client_id=${sessionScope.user.id}">${pageScope.my_training_program}</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=client_check_actual_subscription&client_id=${sessionScope.user.id}">${pageScope.make_order}</a>
                    </li>
                </c:otherwise>
            </c:choose>
        </c:if>
    </ul>
</div>
