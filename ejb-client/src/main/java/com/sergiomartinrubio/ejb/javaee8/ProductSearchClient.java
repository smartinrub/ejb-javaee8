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

@WebServlet(urlPatterns = "/search")
public class ProductSearchClient extends HttpServlet {

    //@EJB(lookup = "java:global/ejb-beans-1.3/SearchFacade!com.sergiomartinrubio.ejb.javaee8.stateless.SearchFacade")
    @EJB
    private ProductSearch productSearch;

    @EJB
    private SearchCount searchCount;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            List<String> products = productSearch.search("diary");
            for (String product : products) {
                out.println(product);
            }
            searchCount.incrementSearchCount();
            out.println(searchCount.getSearchCount());
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
