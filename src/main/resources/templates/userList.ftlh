<!DOCTYPE html>
<html>
<head>
    <title>user list</title>
    <meta charset="UTF-8">
</head>
<body>
<h3 align="center">List of users</h3>
<table>
    <thead>
    <tr>Name</tr>
    <tr>Role</tr>
    </thead>
    <tbody>
    <#list users as user>
        <tr>
            <td>${user.username}</td>
            <td><#list user.roles as role>${role}<#sep>, </#list></td>
            <td><a href="/user/${user.username}">Edit</a> </td>
        </tr>
    </#list>
    </tbody>
</table>
</body>
</html>