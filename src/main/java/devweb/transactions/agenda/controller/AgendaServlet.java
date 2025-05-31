package devweb.transactions.agenda;

import java.io.*;
import java.util.Date;
import java.util.List;

import devweb.transactions.agenda.model.EventModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import javax.xml.crypto.Data;

@WebServlet(name = "agenda", value = "/agenda")
public class AgendaServlet extends HttpServlet {
    Long id = null;
    String eventName = "";
    Date eventDate = null;
    String startHour = "";
    String endHour = "";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


    }

    private List<EventModel> showAgenda(){

        return List.of();
    }

    public void destroy() {
    }
}