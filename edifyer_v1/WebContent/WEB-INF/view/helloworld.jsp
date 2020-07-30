<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1" charset="UTF-8">
<link rel="stylesheet" type="text/css" href="${pageContent.request.contextPath}/resources/css/first.css">
<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style><%@ include file="first.css"%></style>
<title>Hello world time</title>
</head>
<body>
<!--  Name taken from the passed HTML param -->
<h3>Your name: ${param.inputName}</h3>
<br><br>
<!--  Message taken from the model -->
<h3>Message: ${message}</h3>
</body>
</html>