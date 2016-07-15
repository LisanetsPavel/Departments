<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<html>
<head>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/style.css'/>"/>
</head>

<body>
<table class="table-condensed">
    <th>Departments</th>
    <c:forEach items="${allDeps}" var="dep">

        <tr>
            <td><c:out value="${dep.name}"/></td>
            <td class="noWrap"><a class="btn btn-success" href="/showEmpls.do?dep_id=${dep.id}"> List of employees</a>
            </td>
            <td class="noWrap"><a class="btn btn-primary" href="/addDepForm.do?dep_id=${dep.id}"> Edit </a></td>
            <form method="post" action="/deleteDep.do">
                <td class="noWrap"><input class="btn btn-danger" type="submit" value="Delete"></td>
                <input type="hidden" name="dep_id" value="${dep.id}">
            </form>
        </tr>
    </c:forEach>
    <tr>
        <td class="noWrap"><a class="btn btn-primary" href="/addDepForm.do"> Add </a></td>
    </tr>
</table>
</body>
</html>
