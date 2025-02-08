<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Add two number</title>
</head>
<body bgcolor="red" method="get">
<% 
 int i = Integer.parseInt(request.getParameter("num1"));
 int j = Integer.parseInt(request.getParameter("num2"));
 int k = i+j;
out.println("output is "+ k);
%>

</body>
</html>
<!-- 1:02:18:42 TIMESTAMP--> 
