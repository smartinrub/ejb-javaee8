package com.sergiomartinrubio.ejb.javaee8.ejb.client;

import com.sergiomartinrubio.ejb.javaee8.persistence.FooRepository;
import com.sergiomartinrubio.ejb.javaee8.persistence.entity.Foo;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/jpa")
public class JpaClient extends HttpServlet {

    @EJB
    private FooRepository fooRepository;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        fooRepository.save(new Foo());

        try (PrintWriter out = response.getWriter()) {
            out.println("Foos:" + fooRepository.findAll());
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
        return "Jpa servlet";
    }
}
