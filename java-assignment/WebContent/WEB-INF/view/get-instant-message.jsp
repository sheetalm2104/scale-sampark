<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Here</title>
</head>
<body>

 <h2>   Send Message  </h2>
  <form:form action="getMessage" modelAttribute="pendingMessage" method="POST">
  
  <table>
   <tr>
     <td><label>participant_uuid:</label> </td>
     <td><form:input path="participant_uuid" /></td>
   </tr>
   <tr>
     <td><label>message:</label> </td>
     <td><form:input path="message" /></td>
   </tr>
   <tr>
     <td><label></label> </td>
     <td><input type="submit" value="Send Message" /></td>
   </tr>
  </table>
  </form:form>
  
 
</body>
</html>