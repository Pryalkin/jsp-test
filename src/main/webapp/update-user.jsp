<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <title>User Form</title>
</head>
<body>
<form action="get-users">
  <input name="id" type="hidden" value="<%= request.getParameter("id") %>"/>
  <br><br>
  <input name="username" placeholder="username"/>
  <br><br>
  <input name="rating" type="number" step=0.1 placeholder="rating"/>
  <br></br>
  <input name="numberOfVisits" type="number" min=1 placeholder="number of visits"/>
  <br></br>
  <input type="submit" value="Submit" />
</form>
</body>
</html>
