<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/market.css" type="text/css"/>
</head>
<body>
<h1>${marketTitle}</h1>
<p>----------------------</p>
<h1>Products</h1>
<p>----------------------</p>
<form:form>
<table id = productTable>
    <tr>
        <th>Name</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>
</form:form>

<a href="${homeUrl}">Go Home!</a>
<br/>

<sec:authorize access="isAuthenticated()">
<br/>
    <form action="${logOutUrl}" method="post">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
</sec:authorize>

</body>
</html>