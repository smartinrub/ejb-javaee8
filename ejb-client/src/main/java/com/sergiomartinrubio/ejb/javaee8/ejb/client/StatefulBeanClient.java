package com.sergiomartinrubio.ejb.javaee8.ejb.client;

import com.sergiomartinrubio.ejb.javaee8.bean.singleton.SingletonRemote;
import com.sergiomartinrubio.ejb.javaee8.bean.stateful.StatefulRemote;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/stateful")
public class StatefulBeanClient extends HttpServlet {

    // use dependency injection access the remote business
    // interface of an enterprise bean
//    @EJB(lookup = "java:global/ejb-beans-1.3/StatefulBean!com.sergiomartinrubio.ejb.javaee8.stateful.StatefulRemote")
    @EJB
    private StatefulRemote statefulBean;

    @EJB
    private SingletonRemote singletonRemote;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try (PrintWriter out = response.getWriter()) {
            out.println("Adding Number...");
            statefulBean.addNumber(29);
            singletonRemote.increaseCounter();
            List<Integer> numbers = statefulBean.getNumbers();
            for (Integer number : numbers) {
                out.println(number);
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
        return "Stateful Bean servlet";
    }
}
