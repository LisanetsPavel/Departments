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
<div class="col-md-6 col-md-offset-3 ">
    <div class="container">
        <form class="form-horizontal" role="form" action="/addEmpl.do" method="POST">
            <div class="form-group">
                <label class="control-label col-sm-2" for="firstName">First name:</label>
                <div class="col-sm-10">
                    <input value="<c:out value="${emp != null ? emp.firstName : param['firstName']}"/>"
                           name="firstName" type="text" class="form-control" id="firstName">
                    <p class="error"><c:out value="${errors.firstName}"/></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2 " for="lastName">Last Name:</label>
                <div class="col-sm-10">
                    <input value="<c:out value="${emp != null ? emp.lastName : param['lastName']}"/>"
                           name="lastName" type="text" class="form-control" id="lastName">
                    <p class="error" ><c:out value="${errors.lastName}"/></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="birthday">Birthday (YYYY-MM-DD):</label>
                <div class="col-sm-10">
                    <input value="<c:out value="${emp != null ? emp.birthday : param['birthday']}"/>"
                           name="birthday" type="text" class="form-control" id="birthday">
                    <p class="error" ><c:out value="${errors.birthday}"/></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2" for="email">Email:</label>
                <div class="col-sm-10 ">
                    <input value="<c:out value="${emp != null ? emp.email : param['email']}"/>"
                           name="email" type="text" class="form-control" id="email">
                    <p class="error" ><c:out value="${errors.email}"/></p>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-sm-2 " for="salary">Salary:</label>
                <div class="col-sm-10">
                    <input value="<c:out value="${emp != null ? emp.salary : param['salary']}"/>"
                           name="salary" type="text" class="form-control" id="salary">
                    <p class="error" ><c:out value="${errors.salary}"/></p>
                </div>
            </div>
            <c:if test="${not empty emp.id}">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="department">Department:</label>
                    <div class="col-sm-10">
                        <select class="form-control " id="department" name="selected_dep_id">
                            <c:forEach items="${allDeps}" var="dep">
                                <option
                                        <c:if test="${dep.id == emp.department.id}">
                                            selected=selected"
                                        </c:if>
                                        value="<c:out value="${dep.id}"/>"><c:out value="${dep.name}"/></option>
                            </c:forEach>
                        </select>
                    </div>
                </div>
            </c:if>
            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <button type="submit" class="btn btn-success">Ok</button>
                    <a class="btn btn-danger" href="/showEmpls.do?dep_id=${dep_id}">Cancel</a>
                </div>
            </div>
            <input type="hidden" name="emp_id" value="<c:out value="${emp_id}"/>">
            <input type="hidden" name="dep_id" value="<c:out value="${dep_id}"/>">
        </form>
    </div>
</div>
</body>
</html>