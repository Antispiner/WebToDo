<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <link href="" rel="stylesheet">
    <script src="../js/script.js"></script>
    <script src=""></script>
    <title>Today</title>
</head>
<body>
<c:import url="header.jsp"/>
<br>
${errorMessage}
${message}
<form name="today" method="POST" action="/AddTaskServlet">

    <input type="hidden" name="page" value="TODAY"/>
    <input type="hidden" name="type" value="work"/> Today add new target<br>
    <input type="text" name="target" value="" required/>&nbsp;
    <input type="submit" name="newTask" value="ADD"/>&nbsp; <br> <br>
</form>

<h3>TODAY</h3>

<form name='form_name1' method="POST" action="/ActionServlet"  enctype="multipart/form-data">

    ${errorMessage}
    <input type="hidden" name="page" value="TODAY"/>
    <input type="hidden" name="type" value="work"/>
    <c:forEach var="clip" items="${TODAY}">
        <hr/>
        <input type="checkbox" id="cheks" name="check" value="${clip}"/>&nbsp;<c:out value="${clip}"/>

    </c:forEach>
    <hr/>
    <br>
    <a href="javascript:sel_all()" title="Select all/deselect all">Select all/deselect all</a><br>
    <br><br>
    <input type="submit" name="CheckTask" value="RECYCLE_BIN"/>&nbsp;

    <input type="submit" name="CheckTask" value="FIXED"/>&nbsp;

        <input type="file" name="file" size="40"/>&nbsp;
        <input type="submit" name="CheckTask" value="UPLOAD"/>&nbsp;
        <input type="submit" name="CheckTask" value="DOWNLOAD"/>&nbsp;
        <input type="submit" name="CheckTask" value="DELETE_FILE"/>&nbsp;
    </form>

    <br><br>


<c:import url="footer.jsp"/>
<br>
<br>
<br>
</body>
</html>