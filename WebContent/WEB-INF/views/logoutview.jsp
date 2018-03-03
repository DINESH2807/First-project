<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Logout</title>
 <style>
      body{
      	
      color:#6a6f8c;
      }
      
</style>
</head>

<body>

<% session.invalidate(); %>

<h1>You have been successfully logout</h1>

</body>
<div style="padding: 5px;">
 
   <a href="${pageContext.request.contextPath}/">Home</a>
</div>
</html>