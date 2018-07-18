<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Someday</title>
    <script src="../js/script.js"></script>
</head>
<body>
<c:import url="header.jsp" />
<br>
${errorMessage}
${message}
<form name="someday" method="POST" action="/AddTaskServlet" >
    <input type="hidden" name="page" value="SOMEDAY" />
    <input type="hidden" name="type" value="work" />
    Someday add new target (year-mounts-day)<br>
    Date:<br>
    <input type="date"  name="dat" required/><br>
    Target:<br>
    <input type="text" name="target" value="" required/>&nbsp;
    <input type="submit" name="newTask" value="ADD"/>&nbsp; <br> <br>
</form>

<h3>SOMEDAY</h3>
<form name='form_name1' method="POST" action="/ActionServlet"  enctype="multipart/form-data">
    <input type="hidden" name="page" value="SOMEDAY" />
    <input type="hidden" name="type" value="work" />
    <c:forEach var="clip" items="${SOMEDAY}">
        <hr>
        <input type="checkbox" id="cheks" name="check" value="${clip}" />&nbsp;<c:out value="${clip}" />
    </c:forEach>
    <hr>
    <br>
    <a href="javascript:sel_all()" title="Select all/deselect all">Select all/deselect all</a><br>
    <br><br>

    <input type="submit" name="CheckTask" value="RECYCLE_BIN" />&nbsp;
    <input type="submit" name="CheckTask" value="FIXED" />&nbsp;
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <input type="file" name="file" size="10" />&nbsp;
    <input type="submit" name="CheckTask" value="UPLOAD" />&nbsp;
    <input type="submit" name="CheckTask" value="DOWNLOAD" />&nbsp;
    <input type="submit" name="CheckTask" value="DELETE_FILE" />&nbsp;

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
