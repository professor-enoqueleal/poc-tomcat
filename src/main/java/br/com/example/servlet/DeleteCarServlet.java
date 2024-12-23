package br.com.example.servlet;

import br.com.example.dao.CarDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-car")
public class DeleteCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String carId = req.getParameter("id");

        CarDao carDao = new CarDao();

        carDao.deleteCarById(carId);

        resp.sendRedirect("/find-all-cars");

    }

}
