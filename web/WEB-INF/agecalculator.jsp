<%-- 
    Document   : agecalculator
    Created on : 26-May-2022, 10:49:21 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Age Calculator</title>
    </head>
    <body>
        <h1>Age Calculator</h1>
        <form method="post" action="age">
            <label>Enter your age:</label>
            <input type="number" name="age_number" value="${ageNumber}">
            <br>
            <input type="submit" value="Age next birthday">
        </form>
        <p>${message}</p>
    </body>
</html>
