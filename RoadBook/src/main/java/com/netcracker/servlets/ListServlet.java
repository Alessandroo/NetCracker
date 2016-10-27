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
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Vojts on 24.10.2016.
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
    private final double count_records_in_page = 20.0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int page = 1;
        page = Integer.parseInt(request.getParameter("page"));

        BusinessLogic logic = new BusinessLogic();

        int count_pages = (int)(Math.ceil(logic.getCountPage()/count_records_in_page));

        int begin, end;

        if (page > count_pages){
            PrintWriter out = response.getWriter();
            out.print("<h1>+Page are not exist+</h1>");
            return;
        }

        if ((page/10 +1)*10 + 1 > count_pages){
            end = count_pages;
        }
        else {
            if (page % 10 == 0){
                end = (page/10)*10 + 1;
            }
            else {
                end = (page / 10 + 1) * 10 + 1;
            }
        }

        if (page < 11){
            begin = 1;
        }
        else{
            if (page % 10 == 0){
                begin = ((page/10) -1)*10;
            }
            else {
                begin = (page/10)*10;
            }
        }

        ArrayList<Integer> page_list = new ArrayList();
        for(int i = begin; i < end+1; i++){
            page_list.add(i);
        }
        request.setAttribute("pages_list", page_list);

        ArrayList<Record> records_list = logic.getList((int)(((page-1)*count_records_in_page)+1),(int)count_records_in_page);
        request.setAttribute("records_list", records_list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/list.jsp");

        dispatcher.forward(request, response);
    }
}
