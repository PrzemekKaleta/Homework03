package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet04")
public class Servlet04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        Cookie[] cookies = request.getCookies();

        int counter = 0;


        for (Cookie cookie : cookies) {
            if ("test".equals(cookie.getName())) {
                String cookieValue = cookie.getValue();
                counter = Integer.parseInt(cookieValue);
                counter++;
                response.getWriter().println("Fanjno że jesteś tu " + counter + " raz");
                cookie.setValue(Integer.toString(counter));
                response.getWriter().println(cookie.getMaxAge());
                cookie.setMaxAge(365*24*60*60);
                response.addCookie(cookie);

            }

        }

        if(counter==0){

            response.getWriter().println("Witaj tu pierwszy raz");
            Cookie cookie = new Cookie("test","1");
            cookie.setMaxAge(365*24*60*60);
            response.addCookie(cookie);

        }


    }
}
