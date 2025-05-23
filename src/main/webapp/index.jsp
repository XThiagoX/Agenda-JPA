<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, devweb.ex.listingform.EventServlet.Event" %>
<html>
<head>
    <title>Agenda de Eventos</title>
</head>
<body>
<h1>Agenda de Eventos</h1>

<h2>Criar Evento</h2>
<form action="events" method="post">
    <input type="hidden" name="action" value="add" />
    <label>Nome: <input type="text" name="name" required /></label><br/>
    <label>Data: <input type="date" name="date" required /></label><br/>
    <label>Início: <input type="time" name="start" required /></label><br/>
    <label>Término: <input type="time" name="end" required /></label><br/>
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
    <tr><th>Nome</th><th>Data</th><th>Início</th><th>Término</th><th>Ações</th></tr>
    <% for (Event e : events) { %>
    <tr>
        <td><%= e.getName() %></td>
        <td><%= e.getDate() %></td>
        <td><%= e.getStart() %></td>
        <td><%= e.getEnd() %></td>
        <td>
            <form action="events" method="post" style="display:inline;">
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
