<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 06.07.16
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isErrorPage="true" %>

<html>
<head>
    <title>Title</title>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/style.css'/>" />
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
</head>
<body>
<span>Error!!!</span>
<span><c:out value="${pageContext.exception}"/></span>
<a class="btn btn-primary" href="/">Main page</a>
</body>
</html>
