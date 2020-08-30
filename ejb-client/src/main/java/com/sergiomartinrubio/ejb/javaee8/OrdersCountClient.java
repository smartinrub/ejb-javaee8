package com.sergiomartinrubio.ejb.javaee8;

import com.sergiomartinrubio.ejb.javaee8.singleton.SearchCount;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/count")
public class OrdersCountClient extends HttpServlet {

    @EJB
    private SearchCount searchCount;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html:charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            searchCount.resetCounter();
            searchCount.incrementSearchCount();
            out.println("<p>Orders Count:" + searchCount.getSearchCount() + "</p>");
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
        return "Orders count servlet";
    }
}
