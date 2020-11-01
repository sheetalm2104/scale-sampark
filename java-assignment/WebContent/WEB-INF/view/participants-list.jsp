<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registered Partcipants</title>
</head>
<body>
Participants
<h1> All registered Participants </h1>
<div>

<input type="button" value="Add Participant" onclick="window.location.href='showFormForAdd'; return false;" 

class="add-button"
/>
<table>

<tr>
<th>participant id</th>
<th>email id</th>
<th>nick name</th>
<th>Send</th>
<th>Fetch</th>
<th>Delete</th>
</tr>

<c:forEach var="tempParticipants" items="${participants}">
<c:url var="sendMessageLink" value="/showMessageForm">
<c:param name="participant_uuid" value="${tempParticipants.participant_uuid}" />
</c:url>
<c:url var="fetchPendingMessagesLink" value="/fetchPendingMessage">
<c:param name="participant_uuid" value="${tempParticipants.participant_uuid}" />
</c:url>
<c:url var="DeRegistrationLink" value="/deRegister">
<c:param name="participant_uuid" value="${tempParticipants.participant_uuid}" />
</c:url>
<tr>
<td>${ tempParticipants.participant_uuid}</td>
<td>${ tempParticipants.email}</td>
<td>${ tempParticipants.nickName}</td>
<td><a href="${sendMessageLink}">Send Message</a>
<td><a href="${fetchPendingMessagesLink}">Fetch Pending Messages</a>
<td><a href="${DeRegistrationLink}">DeRegister</a>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>