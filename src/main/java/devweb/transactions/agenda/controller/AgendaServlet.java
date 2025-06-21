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
        PrintWriter writer = response.getWriter();
        writer.println("<h1>Agenda</h1>");

        HttpSession session = request.getSession();
        List<Event> events = getEventList(request);

        String name = request.getParameter("name");
        LocalDate date = LocalDate.parse(request.getParameter("date"));
//        String timeStart =  String.valueOf(LocalTime.parse(request.getParameter("startHour")));
//        String timeEnd = String.valueOf(LocalTime.parse(request.getParameter("endHour")));


        // verificando ação de formulário
        String action = request.getParameter("action");{
            if (Objects.equals(action, "add")){
                Event newEvent = new Event(id, name, date, startHour, endHour);


                if (events == null) {
                    events = new ArrayList<>();
                    session.setAttribute("events", events);
                }
                events.add(newEvent);
                System.out.println("Action recebida: ");
                System.out.println("ID para deletar: ");
            }

            else if ("delete".equals(action)) {
                String id = request.getParameter("id");
                System.out.println("Action recebida: ");
                System.out.println("ID para deletar: ");

            }
            response.sendRedirect(request.getContextPath() + "/agenda");
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}