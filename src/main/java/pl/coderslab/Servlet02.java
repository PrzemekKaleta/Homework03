package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/Servlet02")
public class Servlet02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String binaryValue = request.getParameter("value");

        Pattern pattern = Pattern.compile("[01]*");
        Matcher matcher = pattern.matcher(binaryValue);

        int result = 0;

        if(matcher.matches()==false) {
            response.getWriter().println("należy wprowadzić tylko 0 i 1");
            return;
        }

        String[] tab = binaryValue.split("");
        response.getWriter().println(Arrays.toString(tab));

        for(int i=tab.length, j=0; i > 0 ; i--, j++){
            if(tab[i-1].equals("1")){

                result= (int) (result + Math.pow(2.0, j));
                }

            }
        response.getWriter().println(result);
        
    }
}
