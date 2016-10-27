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
import java.util.ArrayList;

/**
 * Created by Vojts on 25.10.2016.
 */
@WebServlet("/edit")
public class EditRecordServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));

        BusinessLogic logic = new BusinessLogic();
        Record record = logic.getRecord(id);
        request.setAttribute("record", record);

        request.setAttribute("action", "edit");
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/record.jsp");

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Record record = new Record(Integer.parseInt(request.getParameter("id")), request.getParameter("country"), request.getParameter("number"), request.getParameter("name"),
                    Integer.parseInt(request.getParameter("longer")), request.getParameter("control"));
            BusinessLogic logic = new BusinessLogic();
            logic.updateRecord(record);
            request.setAttribute("action", "list?page=1");
            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/success.jsp");

            dispatcher.forward(request, response);
        } catch (Exception e){
            request.setAttribute("error" ,e);
            request.setAttribute("action", "edit?=" + request.getParameter("id"));

            RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/failure.jsp");

            dispatcher.forward(request, response);
        }
    }
}
