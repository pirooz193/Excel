package com.maktab.servlets;

import com.maktab.domains.Person;
import com.maktab.excel.ExcelReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;


@WebServlet("/showExcelFile")
@MultipartConfig
public class ShowExcelFile extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("file");
        List<Person> personList = new ExcelReader().excelReader(part.getInputStream());
        req.setAttribute("personList",personList);
        req.getRequestDispatcher("/Excel").forward(req,resp);
    }
}
