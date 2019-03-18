package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Servlet03")
public class Servlet03 extends HttpServlet {

    private HttpSession sess (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        HttpSession sess = request.getSession();

        return sess;
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        HttpSession session = sess(request, response);

        String parametr1 = request.getParameter("name");
        String parametr2 = request.getParameter("surname");
        String parametr3 = request.getParameter("gender");
        String parametr4 = request.getParameter("city");
        String parametr5 = request.getParameter("age");

        session.setAttribute("name", parametr1);
        session.setAttribute("surname", parametr2);
        session.setAttribute("gender", parametr3);
        session.setAttribute("city", parametr4);
        session.setAttribute("age", parametr5);


        response.getWriter().append("<p>Nazywasz się: " + parametr1 + " " + parametr2+ " jesteś z " + parametr4+ " i masz " + parametr5 +" lat.</p>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=UTF-8");

        response.getWriter().append("<form action=\"/Servlet03\" method=\"post\">\n");

        if(sess(request,response).isNew()) {

            response.getWriter().append("imię<input type=\"text\" name=\"name\"><br>");
            response.getWriter().append("nazwisko:<input type=\"text\" name=\"surname\"><br>");
            response.getWriter().append("płeć<input type=\"text\" name=\"gender\"><br>");
            response.getWriter().append("miasto<input type=\"text\" name=\"city\"><br>");
            response.getWriter().append("wiek<input type=\"number\" name=\"age\"><br>");

        }else{

            String parametr1 = (String) sess(request,response).getAttribute("name");
            String parametr2 = (String) sess(request,response).getAttribute("surname");
            String parametr3 = (String) sess(request,response).getAttribute("gender");
            String parametr4 = (String) sess(request,response).getAttribute("city");
            String parametr5 = (String) sess(request,response).getAttribute("age");

            response.getWriter().append("imię<input type=\"text\" name=\"name\" value=\""+ parametr1 + "\"><br>");
            response.getWriter().append("nazwisko:<input type=\"text\" name=\"surname\" value=\""+ parametr2 + "\"><br>");
            response.getWriter().append("płeć<input type=\"text\" name=\"gender\" value=\""+ parametr3 + "\"><br>");
            response.getWriter().append("miasto<input type=\"text\" name=\"city\" value=\""+ parametr4 + "\"><br>");
            response.getWriter().append("wiek<input type=\"number\" name=\"age\" value=\""+ parametr5 + "\"><br>");

        }
        response.getWriter().append("<input type=\"submit\" value=\"Podaj do Post\"></form>");

    }
}
