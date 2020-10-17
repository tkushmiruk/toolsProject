<!DOCTYPE html>
<html>
<head>Registration page</head>
<body>
    <form action="/registration" method="post">
        <div><label> User Name : <input type="text" name="username"/> </label></div>
        <div><label> Password: <input type="password" name="password"/> </label></div>
        <input type="hidden" name="_csrf" value="${_csrf.token}" />
        <div><input type="submit" value="registration"/></div>
    </form>
<div>
    <a href="/login">Login page</a>
</div>
</body>
</html>