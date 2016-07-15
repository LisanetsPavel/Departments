<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/bootstrap.min.css'/>"/>
    <link media="all" rel="stylesheet" type="text/css"
          href="<c:url value='/resources/css/style.css'/>"/>
</head>
<body>
<div class="col-md-6 col-md-offset-3">
    <div class="container">
        <form class="form-horizontal" action="/addDep.do" method="post">
            <table id="table">
                <div class="form-group">
                    <label class="control-label col-sm-2" for="name"> Type name : </label>
                    <div class="col-sm-10"><input id="name" class="form-control"
                                                  value="<c:out value="${ dep != null ? dep.name : param['name']}"/>"
                                                  name="name"
                                                  type="text">
                        <p class="error"><c:out value="${errors.name}"/></p></div>
                </div>
                <div class="col-sm-10 col-md-o">
                    <input type="submit" class="btn btn-success" value="Ок">
                    <a class="btn btn-danger" href="/">Cancel</a>
                    <input type="hidden" name="dep_id" value="<c:out value="${dep.id}"/>">
                </div>
            </table>
        </form>
    </div>
</div>
</body>
</html>
