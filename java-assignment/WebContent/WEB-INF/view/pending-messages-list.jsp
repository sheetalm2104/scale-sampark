<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Messages</title>
</head>
<body>
<h1> Your messages </h1>
<table>
<c:forEach var="tempParticipants" items="${messages}">
<tr>
<td>${tempParticipants}</td>
</tr>

</c:forEach>
</table>
</body>
</html>