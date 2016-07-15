<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<table class="table-condensed">
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Birthday</th>
        <th>Email</th>
        <th>Salary</th>
    </tr>
    <c:forEach items="${empls}" var="empl">
        <tr>
            <td><c:out value="${empl.firstName}"/></td>
            <td><c:out value="${empl.lastName}"/></td>
            <td><c:out value="${empl.birthday}"/></td>
            <td><c:out value="${empl.email}"/></td>
            <td><c:out value="${empl.salary}"/></td>

            <td class="noWrap ">
                <a class="btn btn-primary" href="/addEmplForm.do?emp_id=${empl.id}&dep_id=${dep_id}">Edit</a>
            </td>
            <td class="noWrap">
                <form action="deleteEmpl.do" method="post">
                    <input type="hidden" name="emp_id" value="${empl.id}"/>
                    <input class="btn btn-danger" type="submit" value="Delete">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td class="noWrap"><a class="btn btn-primary" href="/addEmplForm.do?dep_id=${dep_id}">Add</a></td>
        <td class="noWrap"><a class="btn btn-danger" href="/">Back</a></td>
    </tr>
</table>
</body>
</html>
