<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@attribute name="coaches" required="true" type="java.util.List" %>
<%@attribute name="role" required="true" rtexprvalue="true" type="java.lang.String" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link href="https://fonts.googleapis.com/css?family=Open+Sans+Condensed:300,300i,700&amp;subset=cyrillic"
      rel="stylesheet">

<fmt:bundle basename="page_content">
    <fmt:message key="client.name" var="name"/>
    <fmt:message key="client.order" var="order"/>
    <fmt:message key="client.telephone" var="telephone"/>
    <fmt:message key="client.training_program" var="training_program"/>
    <fmt:message key="client.describe" var="describe"/>
    <fmt:message key="client.delete_client" var="delete_client"/>
</fmt:bundle>

<div class="table_user">
    <table>
        <tr>
            <th><span>&#8470;</span></th>
            <th>ID</th>
            <th>${pageScope.name}</th>
            <th>${pageScope.telephone}</th>
            <th>
                    ${pageScope.training_program}
              </th>
            <th></th>
        </tr>
        <c:forEach var="coach" items="${coaches}">
            <c:set var="count" value="${pageScope.count+1}"/>
            <tr>
                <td>${count}</td>
                <td>${coach.id}</td>
                <td>${coach.firstName} ${coach.lastName}</td>
                <td>${coach.telephone}</td>
                <td>
                    <c:choose>
                        <c:when test="${role.equals('COACH')}">
                            <a href="controller?command=special_show_client_program&client_id=${coach.id}">${pageScope.describe}
                                <i class="fa fa-info-circle" aria-hidden="true"></i></a>
                        </c:when>
                        <c:otherwise>
                            <a href="controller?command=special_show_client_subscriptions&client_id=${coach.id}">${pageScope.describe}
                                <i class="fa fa-info-circle" aria-hidden="true"></i></a>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="controller?command=admin_delete_coach&coach_id=${coach.id}">${pageScope.delete_client}
                </td>
            </tr>
        </c:forEach>
    </table>
</div>