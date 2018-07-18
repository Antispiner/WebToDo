<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Header</title>
    <link href="" rel="stylesheet">
</head>
<body>
<header>
    <div class="main-nav">
        <span class="todo">Hello,  ${UserName.getLogin()}!</span>
        <div class="positionIndexButton">
            <form name="today" method="POST" action="/DistributionServlet" >
                <input type="submit" name="page" value="RECYCLE_BIN" />&nbsp;
                <input type="submit" name="page" value="TOMORROW" />&nbsp;
                <input type="submit" name="page" value="TODAY" />&nbsp;
                <input type="submit" name="page" value="SOMEDAY" />&nbsp;
                <input type="submit" name="page" value="FIXED" />&nbsp;
                <a class="my_log" href="/logout">LOG OUT</a>&nbsp; <br>
            </form>
        </div>
    </div>
</header>
</body>
</html>