package com.maktab.servlets;

import com.maktab.domains.Person;
import com.maktab.excel.ExcelWriter;
import com.maktab.repository.PersonRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getExcelFile")
public class GetExcelFile extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        resp.setHeader("Content-disposition", "attachment; filename=\"MyExcel.xlsx\"");

        PersonRepositoryImpl personRepository = PersonRepositoryImpl.getInstance();

        List<Person> personList = personRepository.loadAll();
        Person[] personArray = new Person[personList.size()];
        for (int i = 0; i < personList.size(); i++) {
            personArray[i] = new Person();
            personArray[i] = personList.get(i);
        }

        ExcelWriter excelWriter = new ExcelWriter();
        try {
            excelWriter.excel(personArray,resp.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.flushBuffer();
    }
}
