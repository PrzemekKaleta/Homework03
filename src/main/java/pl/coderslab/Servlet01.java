package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/Servlet01")
public class Servlet01 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");
        String parametreValue = request.getParameter("value");
        int value = Integer.valueOf(parametreValue);

        Map<String, Double>Currencies = new HashMap<>();

        Currencies.put("USD", 3.8014);
        Currencies.put("EUR", 4.3037);
        Currencies.put("PLN", 1.0);

        double result = value * Currencies.get(fromCurrency) / Currencies.get(toCurrency);

        response.getWriter().println("Zamiana " + value + " " + fromCurrency + " da " + result + " " + toCurrency);

    }

}
