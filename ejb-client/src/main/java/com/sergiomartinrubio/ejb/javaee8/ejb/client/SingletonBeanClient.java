package com.sergiomartinrubio.ejb.javaee8.ejb.client;

import com.sergiomartinrubio.ejb.javaee8.bean.singleton.SingletonRemote;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/singleton")
public class SingletonBeanClient extends HttpServlet {

    @EJB
    private SingletonRemote singletonBean;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("Counter is:" + singletonBean.getCounter());
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
        return "Singleton Bean servlet";
    }
}
