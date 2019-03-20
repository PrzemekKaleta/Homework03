package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/Servlet05_2")
public class Servlet05_2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("<h2>Jesteś w koszyku: </h2>");

        HttpSession sess = request.getSession();

        Double totalCost = 0.0;

        Map<Product, Integer> checkBasket = (Map<Product, Integer>) sess.getAttribute("basket");
        Iterator it = checkBasket.entrySet().iterator();
        while (it.hasNext()) {

            Map.Entry keyValue = (Map.Entry)it.next();

            Integer quantityOfProduct = (Integer) keyValue.getValue();
            Product product = (Product) keyValue.getKey();

            String nameOfProduct = product.getName();
            Double priceOfProduct = product.getPrice();

            Double costOfThoseProduct = priceOfProduct * quantityOfProduct;

            response.getWriter().append("<br>" + nameOfProduct + '\t' + quantityOfProduct + " x " + priceOfProduct + " = " + costOfThoseProduct);

            totalCost+=costOfThoseProduct;

        }
        response.getWriter().append("<br>SUMA: " + totalCost);

    }
}
