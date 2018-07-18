<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ru">

<head>
    <meta charset="UTF-8">
    <title>login</title>
    <link href="../../css/login.css" rel="stylesheet">
</head>

<body>
    <div class="wrap">
        <div class="content-wrap content-wrap-width">
            <div class="form-wrap">
                <div class="pp-brand">
                    <a href="#" class="pp-brand__logo"></a>
                </div>

                <form method="post" action="/LoginServlet">
                    ${Message}
                    <input type="text" required placeholder="login" name="login"><br>
                    <input type="password" required placeholder="password" name="password"><br><br>
                    <input class="button" type="submit" value="Войти">

                </form>
                </div>
            </div>
            </div>
</body>
</html>