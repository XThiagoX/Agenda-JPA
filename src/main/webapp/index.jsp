<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="devweb.transactions.agenda.model.Event" %>
<html>
<head>
    <title>Agenda de Eventos</title>
</head>
<body>
<h1>Agenda de Eventos</h1>

<h2>Criar Evento</h2>
<form action="http://localhost:8080/Agenda-1.0-SNAPSHOT/agenda" method="post">
    <input type="hidden" name="action" value="add" />
    <label>Nome: <input type="text" name="name" required /></label><br/>
    <label>Data: <input type="date" name="date" required /></label><br/>
    <label>Início: <input type="time" name="startHour" required /></label><br/>
    <label>Término: <input type="time" name="endHour" required /></label><br/>
    <button type="submit">Adicionar</button>
</form>

<h2>Eventos</h2>

<%
    List<Event> events = (List<Event>) session.getAttribute("events");
    if (events == null || events.isEmpty()) {
%>
<p>Não há eventos.</p>
<% } else { %>
<table border="1">
    <tr><th>id</th><th>Nome</th><th>Data</th><th>Início</th><th>Término</th><th>Ações</th></tr>
    <% for (Event e : events) { %>
    <tr>
        <td><%= e.getId() %></td>
        <td><%= e.getEventName() %></td>
        <td><%= e.getEventDate() %></td>
        <td><%= e.getStartHour() %></td>
        <td><%= e.getEndHour() %></td>
        <td>
            <form action="agenda" method="post" style="display:inline;">
                <input type="hidden" name="action" value="delete" />
                <input type="hidden" name="id" value="<%= e.getId() %>" />
                <button type="submit">Excluir</button>
            </form>
        </td>
    </tr>
    <% } %>
</table>
<% } %>
</body>
</html>
