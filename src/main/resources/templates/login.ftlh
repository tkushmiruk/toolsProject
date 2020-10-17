<!DOCTYPE html>
<html>
<head>Login Page </head>
<body>
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <div><input type="submit" value="sign in"/></div>
</form>
<form action="/logout">
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <button type="button">Log out</button>
</form>
    <div>
        <a href="/registration">Registration</a>
    </div>
</body>
</html>