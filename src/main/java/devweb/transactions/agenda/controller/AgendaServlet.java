package devweb.transactions.agenda.controller;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import devweb.transactions.agenda.model.Event;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "agenda", value = "/agenda")
public class AgendaServlet extends HttpServlet {
    Long id = null;
    String eventName = "";
    Date eventDate = null;
    String startHour = "";
    String endHour = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        PrintWriter writer = response.getWriter();
        writer.println("<h1>Página está sendo acessada </h1>");
        String name = request.getParameter("name");
        String date = String.valueOf(LocalDate.parse(request.getParameter("date")));
        String timeStart =  String.valueOf(LocalTime.parse(request.getParameter("startHour")));
        String timeEnd = String.valueOf(LocalTime.parse(request.getParameter("endHour")));

        // verificando ação de formulário
        String action = request.getParameter("action");{
            if (Objects.equals(action, "add")){
                response.setContentType("text/html");
                writer.println("<ul>");
                writer.println("<il> Nome: " + name + "</il>");
                writer.println("<il> Date: " + date + "</il>");
                writer.println("<il> Horário de Início: " + timeStart + "</il>");
                writer.println("<il> Horário de Termino: " + timeEnd + "</il>");
                writer.println("/<ul>");

            }
        }


    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        request.getRequestDispatcher("/index.jsp").forward(request, response);


    }

    private List<Event> showAgenda(){

        return List.of();
    }

    public void destroy() {
    }
}