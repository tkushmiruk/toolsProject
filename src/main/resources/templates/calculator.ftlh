<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
    <meta charset="UTF-8">
</head>
<body>
<h2 align="center">Calculator</h2>
<form action="/calculator" method="post">
    <input type="text" name="formula" />
    <input type="hidden" name="_csrf" value="${_csrf.token}" />
    <input type="submit" value="calculate"/>
</form>
<#if result??>
<div>${result}</div>
</#if>
</body>


</html>