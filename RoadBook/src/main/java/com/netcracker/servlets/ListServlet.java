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
 * Created by Vojts on 24.10.2016.
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BusinessLogic logic = new BusinessLogic();
        ArrayList<Record> list = logic.getList();
        request.setAttribute("list", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/list.jsp");

        dispatcher.forward(request, response);
    }
}
