package com.servlets;

import com.maktab.domains.Person;
import com.maktab.repository.PersonRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/loadData")
public class LoadDataBaseData extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PersonRepositoryImpl personRepository = PersonRepositoryImpl.getInstance();
        List<Person> personList = personRepository.loadAll();

        req.setAttribute("personList", personList);
        req.getRequestDispatcher("/Excel").forward(req, resp);

    }
}
