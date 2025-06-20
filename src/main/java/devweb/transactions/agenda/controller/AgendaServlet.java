package devweb.transactions.agenda.controller;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;

import devweb.transactions.agenda.model.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "agenda", value = "/agenda")
public class AgendaServlet extends HttpServlet {
    String id = UUID.randomUUID().toString();
    String eventName = "";
    Date eventDate = null;
    String startHour = "";
    String endHour = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        String action = request.getParameter("action");

        List<Event> events = (List<Event>) session.getAttribute("events");

        // verificando ação de formulário

            if (Objects.equals(action, "add")){
                String name = request.getParameter("name");
                LocalDate date = LocalDate.parse(request.getParameter("date"));
                String startHour =  String.valueOf(LocalTime.parse(request.getParameter("startHour")));
                String endHour = String.valueOf(LocalTime.parse(request.getParameter("endHour")));

                Event newEvent = new Event(id, name, date, startHour, endHour);

                if (events == null) {
                    events = new ArrayList<>();
                    session.setAttribute("events", events);
                }
                events.add(newEvent);
            } else if (Objects.equals(action, "delete")) {
                String id = request.getParameter("id");
                events.removeIf(event -> event.getId().equals(id));
            }

        response.sendRedirect(request.getContextPath() + "/agenda");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}