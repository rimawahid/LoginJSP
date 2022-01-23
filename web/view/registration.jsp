<%-- 
    Document   : registration
    Created on : Jan 23, 2022, 7:35:34 AM
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration Form</title>
    </head>
    <body>
        <h1>User Registration</h1>
        <form action="register" method="POST">
             <input type="text" placeholder="Username" name ="username"><br><br>
            Emil : <input type="text" name ="email"><br><br>
            Password : <input type="password" name ="password"><br><br>

            <input type="checkbox"/> I read and agree to Terms & Conditions<br><br>
            <input type="submit" value="CREATE ACCOUNT"/>
        </form>
        <br><br>
        Already have an account?<a href="view/login.jsp">Sign in</a>
    </body>
</html>
