package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@WebServlet("/Servlet05_1")
public class Servlet05_1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        String paramProduct = request.getParameter("product");

        String paramQuantity = request.getParameter("quantity");
        Integer rightQuantity = Integer.valueOf(paramQuantity);

        String paramPrice = request.getParameter("price");
        Double rightPrice = Double.valueOf(paramPrice);

        Product product = new Product(paramProduct, rightPrice);


        HttpSession sess = request.getSession();

        if(sess.getAttribute("basket")==null){

            Map<Product, Integer> productIntegerMap = new HashMap<>();

            productIntegerMap.put(product,rightQuantity);

            sess.setAttribute("basket", productIntegerMap);
        }else{
            Map<Product, Integer> findBasket = (Map<Product, Integer>) sess.getAttribute("basket");
            if(findBasket.containsKey(product)){
                Integer toAdd = findBasket.get(product) + rightQuantity;
                findBasket.put(product, toAdd);
            }else{
                findBasket.put(product,rightQuantity);
            }
            sess.setAttribute("basket",findBasket);
        }

        response.getWriter().append("<p>Produkt został dodany do kosztyka</p>");

        doGet(request,response);

        response.getWriter().append("<br><form action=\"/Servlet05_2\" method=\"get\">")
                .append("<input type=\"submit\" value=\"Przejdź do kosztyka\"></form>");



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        response.getWriter().append("<form action=\"/Servlet05_1\" method=\"post\">")
                .append("Produkt<br>")
                .append("<input type=\"text\" name=\"product\"><br>")
                .append("Ilość<br>")
                .append("<input type=\"number\" name=\"quantity\" min=\"1\" value=\"1\"><br>")
                .append("Cena<br>")
                .append("<input type=\"number\" name=\"price\" min=\"0\" value=\"0.99\" step=\".01\"><br>")
                .append("<input type=\"submit\" value=\"Dodaj\"></form>");


    }
}
