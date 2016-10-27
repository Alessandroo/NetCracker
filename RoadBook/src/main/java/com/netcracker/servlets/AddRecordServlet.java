package com.netcracker.servlets;

import com.netcracker.businesslayer.BusinessLogic;
import com.netcracker.model.Record;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vojts on 25.10.2016.
 */
@WebServlet("/add")
public class AddRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("action", "add");
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/record.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Record record = new Record(0, request.getParameter("country"), request.getParameter("number"), request.getParameter("name"),
                    Integer.parseInt(request.getParameter("longer")), request.getParameter("control"));
            BusinessLogic logic = new BusinessLogic();
            logic.saveRecord(record);
            request.setAttribute("action", "list?page=1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/success.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e){
            request.setAttribute("error" ,e);
            request.setAttribute("action", "add");

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/failure.jsp");

            dispatcher.forward(request, response);
        }
    }
}
