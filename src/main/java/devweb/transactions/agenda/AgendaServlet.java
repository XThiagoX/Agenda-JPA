package devweb.transactions.agenda;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "agenda", value = "/agenda")
public class agenda extends HttpServlet {
    private String message;

    public void init() {
        message = "Agenda";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


    }

    public void destroy() {
    }
}