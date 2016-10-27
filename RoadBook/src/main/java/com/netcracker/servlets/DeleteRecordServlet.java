package com.netcracker.servlets;

import com.netcracker.businesslayer.BusinessLogic;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vojts on 26.10.2016.
 */
@WebServlet("/delete")
public class DeleteRecordServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            BusinessLogic logic = new BusinessLogic();
            logic.deleteRecord(id);
            request.setAttribute("action", "list?page=1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/success.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e){
            request.setAttribute("error" ,e);
            request.setAttribute("action", "list");

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/failure.jsp");

            dispatcher.forward(request, response);
        }
    }
}
