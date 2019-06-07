package controller;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AjaxController", urlPatterns = "/AjaxController")
public class AjaxController extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        respond(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        respond(request,response);

    }

    private void respond(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action.equals("demo1")){
            double num1 = 0;
            double num2 = 0;
            try {
                num1 += Double.parseDouble(request.getParameter("num1"));
                num2 += Double.parseDouble(request.getParameter("num2"));
            }catch (NumberFormatException e){
                out.println("incorrect data");
                return;
            }

            out.println(num1+num2);
        }

    }

}
