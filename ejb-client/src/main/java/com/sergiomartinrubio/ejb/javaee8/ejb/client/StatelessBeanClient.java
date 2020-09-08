package com.sergiomartinrubio.ejb.javaee8.ejb.client;

import com.sergiomartinrubio.ejb.javaee8.bean.stateless.StatelessRemote;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/stateless")
public class StatelessBeanClient extends HttpServlet {

    //@EJB(lookup = "java:global/ejb-beans-1.3/StatelessBean!com.sergiomartinrubio.ejb.javaee8.stateless.StatelessRemote")
    @EJB
    private StatelessRemote statelessBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            boolean isFound = statelessBean.isFound("House");
            out.println(isFound);
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
        return "Stateless Bean Servlet.";
    }
}
