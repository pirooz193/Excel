package com.servlets;

import com.maktab.domains.*;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class ExcelDemo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        List<Person> personList = (List<Person>) req.getAttribute("personList");
        Person[] personArray = new Person[personList.size()];
        StringBuilder rows = new StringBuilder();
        for (int i = 0; i < personList.size(); i++) {
            personArray[i] = new Person();
            personArray[i] = personList.get(i);
            rows.append("<tr>\n" +
                    "\n" +
                    "            <td><div class=\"data\">" + personArray[i].getId() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getName() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getLastName() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getPhoneNumber() + "</div></td>\n" +
                    "\n" +
                    "        </tr>");
        }


        out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Excel</title>\n" +
                "    <link rel=\"stylesheet\" href=\"Excel.css\">\n" +
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<table cellpadding=\"0\" ; cellspacing=\"0\">\n" +
                "  <a href=\"./getExcelFile\" ><img src=\"icons8-microsoft-excel-64%20(1).png\"></a>\n" +
                "<div class=\"topOfTable\" >\n" +
                "            <tr>\n" +
                "\n" +
                "                <td class=\"topOfTable\"><label>Id</label></td>\n" +
                "                <td class=\"topOfTable\">name</td>\n" +
                "                <td class=\"topOfTable\">last name</td>\n" +
                "                <td class=\"topOfTable\">phone number</td>\n" +
                "\n" +
                "            </tr>\n" +
                "        </div>" + rows +
                "       \n" +

                "    <br>\n" +
                "\n" +
                "    <br>\n" +
                "\n" +
                "</table>\n" +
                "</body>\n" +
                "</html>");

        out.close();
    }
}
