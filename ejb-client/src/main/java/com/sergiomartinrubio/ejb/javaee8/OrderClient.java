package com.sergiomartinrubio.ejb.javaee8;

import com.sergiomartinrubio.ejb.javaee8.stateful.Order;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/order")
public class OrderClient extends HttpServlet {

    // use dependency injection access the remote business
    // interface of an enterprise bean
//    @EJB(lookup = "java:global/ejb-beans-1.3/OrderBean!com.sergiomartinrubio.ejb.javaee8.stateful.Order")
    @EJB
    private Order order;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            order.addItem("milk");
            List<String> items = order.getItems();
            for (String item : items) {
                out.println(item);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Order servlet";
    }
}
