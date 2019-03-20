package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet06")
public class Servlet06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        int x1 = Integer.parseInt(request.getParameter("x1"));
        int x2 = Integer.parseInt(request.getParameter("x2"));
        int x3 = Integer.parseInt(request.getParameter("x3"));
        int x4 = Integer.parseInt(request.getParameter("x4"));

        response.getWriter().append("<h4> wybrane liczby: </h4>")
        .append("<p> liczba 1 = " + x1 + "</p>")
        .append("<p> liczba 2 = " + x2 + "</p>")
        .append("<p> liczba 3 = " + x3 + "</p>")
        .append("<p> liczba 4 = " + x4 + "</p>");

        int sum = x1 + x2 + x3 + x4;

        double average = sum / 4.0;

        int product = x1 * x2 * x3 * x4;

        response.getWriter().append("<h4> działania na wybranych liczbach: </h4>")
                .append("<p> suma: = " + sum + "</p>")
                .append("<p> średnia: = " + average + "</p>")
                .append("<p> iloczyn: = " + product + "</p>");




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
