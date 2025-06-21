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

    @SuppressWarnings("unchecked")
    private List<Event> getEventList(HttpServletRequest request ) throws ServletException, IOException {
        List<Event> list = (List<Event>) request.getSession().getAttribute("events");
        if (list == null){
            list = new ArrayList<>();
            request.getSession().setAttribute("events", list);
        }
        return list;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        List<Event> events = getEventList(request);

        String action = request.getParameter("action");{
            if (Objects.equals(action, "add")){
                String id = UUID.randomUUID().toString();
                String name = request.getParameter("name");
                LocalDate date = LocalDate.parse(request.getParameter("date"));
                String startHour =  String.valueOf(LocalTime.parse(request.getParameter("startHour")));
                String endHour = String.valueOf(LocalTime.parse(request.getParameter("endHour")));
                events.add(new Event(id, name, date, startHour, endHour));
            } else if (Objects.equals(action, "delete")) {
                String enventId = request.getParameter("id");
                events.removeIf(e -> e.getId().equals(enventId));
            }
            response.sendRedirect(request.getContextPath() + "/agenda");
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}