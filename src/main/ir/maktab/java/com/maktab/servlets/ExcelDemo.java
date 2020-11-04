package com.maktab.servlets;

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
        String test=" ";
        for (int i = 0; i < personList.size(); i++) {
            personArray[i] = new Person();
            personArray[i] = personList.get(i);

//            Wrong:
            /*test.concat("<tr>\n" +
                    "\n" +
                    "            <td><div class=\"data\">" + personArray[i].getId() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getName() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getLastName() + "</div></td>\n" +
                    "            <td><div class=\"data\">" + personArray[i].getPhoneNumber() + "</div></td>\n" +
                    "\n" +
                    "        </tr>");*/
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
                "    <link rel=\"stylesheet\" href=\"Excel.css\">\n" +"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css\">\n" +
                "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js\"></script>\n" +
                "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js\"></script>\n" +
                "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js\"></script>"+
                "\n" +
                "</head>\n" +
                "<body>\n" +
                "<table cellpadding=\"0\" ; cellspacing=\"0\">\n" +
                "  <a href=\"./getExcelFile\" ><div class=\"container\">\n" +
                "                    <button type=\"button\" class=\"btn\" data-toggle=\"modal\" data-target=\"#myModal\">\n" +
                "                        <img src=\"icons8-microsoft-excel-64%20(1).png\">\n" +
                "                    </button>\n" +
                "                    <div class=\"modal\" id=\"myModal\">\n" +
                "                        <div class=\"modal-dialog\">\n" +
                "                            <div class=\"modal-content\">\n" +
                "                                <div class=\"modal-header\">\n" +
                "                                    <h4 class=\"modal-title\">Download Started</h4>\n" +
                "                                    <button type=\"button\" class=\"close\" data-dismiss=\"modal\">&times;</button>\n" +
                "                                </div>\n" +
                "                                <div class=\"modal-body\">\n" +
                "                                    ...Excel File...\n" +
                "                                </div>\n" +
                "                                <div class=\"modal-footer\">\n" +
                "                                    <button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Close</button>\n" +
                "                                </div>\n" +
                "\n" +
                "                            </div>\n" +
                "                        </div>\n" +
                "                    </div>\n" +
                "\n" +
                "                </div></a>\n" +
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
