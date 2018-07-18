<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script src="../js/script.js"></script>
    <title>Fixed</title>
</head>
<body>
<c:import url="header.jsp" />
<br>
${errorMessage}
${message}
<form name="today" method="POST" action="/DistributionServlet" >
    <input type="hidden" name="page" value="FIXED" />
</form>

<h3>FIXED</h3>
<form name='form_name1' method="POST" action="/ActionServlet" enctype="multipart/form-data">
    <input type="hidden" name="page" value="FIXED" />
    <input type="hidden" name="type" value="fixed" />
    <c:forEach var="clip" items="${FIXED}">
        <hr>
        <input type="checkbox" id="cheks" name="check" value="${clip}" />&nbsp;<c:out value="${clip}" />
    </c:forEach>
    <hr>
    <br>
    <a href="javascript:sel_all()" title="Select all/deselect all">Select all/deselect all</a><br>
    <br><br>

    <input type="submit" name="CheckTask" value="RECYCLE_BIN" />&nbsp;


    &nbsp;<br><br><br>
</form>
<br>
<br>
<c:import url="footer.jsp" />
<br>
<br>
<br>
</body>
</html>
