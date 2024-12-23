package br.com.example.servlet;


import br.com.example.dao.CarDao;
import br.com.example.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/find-all-cars")
public class ListCarServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        CarDao carDao = new CarDao();

        List<Car> allCars = carDao.findAllCars();

        req.setAttribute("cars", allCars);

        req.getRequestDispatcher("/dashboard.jsp").forward(req, resp);

    }

}
