<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<spring:url value="/" var="homeUrl"/>
<spring:url value="/logout/" var="logOutUrl"/>

<html>
<head>
    <link rel="stylesheet" href="/css/market.css" type="text/css"/>
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
<br/>
<a href="${logOutUrl}">Logout</a>

</body>
</html>