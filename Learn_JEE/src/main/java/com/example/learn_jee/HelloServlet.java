package com.example.learn_jee;

import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String name = request.getParameter("name");
        request.setAttribute("name",name);


        //Forward the Response To the JSP page
        request.getRequestDispatcher("Example.jsp").forward(request,response);
    }

    public void destroy() {
    }
}