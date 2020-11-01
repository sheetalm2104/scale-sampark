<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
</head>
<body>

 <h2>   Please Register  </h2>
  <form:form action="registerParticipant" modelAttribute="participant" method="POST">
  
  <table>
   <tr>
     <td><label>Email:</label> </td>
     <td><form:input path="email" /></td>
   </tr>
   <tr>
     <td><label>Nickname:</label> </td>
     <td><form:input path="nickName" /></td>
   </tr>
   <tr>
     <td><label></label> </td>
     <td><input type="submit" value="Register" /></td>
   </tr>
  </table>
  </form:form>
  
 
</body>
</html>