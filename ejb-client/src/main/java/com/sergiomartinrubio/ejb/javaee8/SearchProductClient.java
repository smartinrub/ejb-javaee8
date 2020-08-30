package com.sergiomartinrubio.ejb.javaee8;

import com.sergiomartinrubio.ejb.javaee8.singleton.SearchCount;
import com.sergiomartinrubio.ejb.javaee8.stateless.ProductSearch;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Logger;

@WebServlet(urlPatterns = "/search")
public class SearchProductClient extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(SearchProductClient.class.getName());

    //@EJB(lookup = "java:global/ejb-beans-1.3/SearchFacade!com.sergiomartinrubio.ejb.javaee8.stateless.SearchFacade")
    @EJB
    private ProductSearch productSearch;

    @EJB
    private SearchCount searchCount;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            List<String> products = productSearch.search("diary");
            out.println("<ul>");
            for (String product : products) {
                out.println("<li>" + product + "</li>");
            }
            out.println("</ul>");
            searchCount.incrementSearchCount();
            out.println("<p>" + searchCount.getSearchCount() + "</p>");
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
        return "Short description";
    }
}
