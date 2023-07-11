<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<div align="center">
    <h1>Web Calcultor</h1>
    <form action="calculate" method = "get">
        <p>
            Input Number A : <input type="number" name="a" required />
        </p>
        <p>
            Input Number B : <input type="number" name="b" required />
        </p>
        <p>
            <input type="submit" value="RUN" />
        </p>
    </form>
</div>
</body>
</html>