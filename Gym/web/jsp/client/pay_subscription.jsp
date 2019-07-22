<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 22.07.2019
  Time: 13:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="tagSql" uri="tag" %>

<fmt:bundle basename="page_content">
    <fmt:message key="order.pay_title" var="title"/>
    <fmt:message key="order.purchase_date" var="purchase_date"/>
    <fmt:message key="order.end_date" var="end_date"/>
    <fmt:message key="order.duration" var="duration"/>
    <fmt:message key="order.personal_trainer" var="personal_trainer"/>
    <fmt:message key="order.status" var="status"/>
    <fmt:message key="order.yes_message" var="yes"/>
    <fmt:message key="order.no_message" var="no"/>
    <fmt:message key="order.not_payed_message" var="not_payed"/>
    <fmt:message key="order.pay_button" var="pay_button"/>
    <fmt:message key="order.edit_button" var="edit_button"/>
    <fmt:message key="order.month_duration" var="month"/>
    <fmt:message key="order.week_duration" var="week"/>
    <fmt:message key="order.year_duration" var="year"/>
    <fmt:message key="order.discount" var="discount"/>
    <fmt:message key="order.ibm" var="ibm"/>
</fmt:bundle>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
    <title>${pageScope.title}</title>
</head>
<body class="page">
<tag:userMenu/>
<div class="table_order">
    <table>
        <tr>
            <th>${pageScope.purchase_date}</th>
            <th>${pageScope.end_date}</th>
            <th>${pageScope.duration}</th>
            <th>${pageScope.personal_trainer}</th>
            <th>${pageScope.discount} <tagSql:client_discount id="${sessionScope.user.id}"/></th>
            <th>${pageScope.status}</th>
            <th>${pageScope.ibm}</th>
        </tr>
        <tr>
            <td>${sessionScope.subscription.purchaseDate}</td>
            <td>${sessionScope.subscription.expirationDate}</td>
            <td>
                <c:choose>
                    <c:when test="${sessionScope.subscription.subscriptionType == 'MONTH'}">
                        ${pageScope.month}
                    </c:when>
                    <c:when test="${sessionScope.subscription.subscriptionType == 'WEEK'}">
                        ${pageScope.week}
                    </c:when>
                    <c:otherwise>
                        ${pageScope.year}
                    </c:otherwise>
                </c:choose>
            </td>
            <td><c:choose>
                <c:when test="${sessionScope.subscription.isCoachNeeded == 1}">${pageScope.yes}</c:when>
                <c:otherwise>${pageScope.no}</c:otherwise>
            </c:choose>
            </td>
            <td>${sessionScope.subscription.price}</td>
            <td>${pageScope.not_payed}</td>
            <td>${sessionScope.subscription.ibm}</td>
        </tr>
    </table>
</div>
<div class="pay_button">
    <ul>
        <li>
            <form action="${pageContext.request.contextPath}/jsp/client/prepare_subscription.jsp">
                <button type="submit">${pageScope.edit_button} <i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                </button>
            </form>
        </li>
        <li>
            <form method="POST" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="client_pay_subscription"/>
                <button type="submit">${pageScope.pay_button} <i class="fa fa-credit-card" aria-hidden="true"></i>
                </button>
            </form>
        </li>
    </ul>
</div>
</body>
</html>
