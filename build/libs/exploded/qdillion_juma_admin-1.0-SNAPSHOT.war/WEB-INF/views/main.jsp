<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017. 11. 16.
  Time: PM 5:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
${name}
<spring:forEach items="${users}" var="i">
    ${i.uName}
</spring:forEach>
<spring:if test="${fn:length(users) < 1}">
    Nothing Here
</spring:if>
test
test
test
test
test
</body>
</html>
