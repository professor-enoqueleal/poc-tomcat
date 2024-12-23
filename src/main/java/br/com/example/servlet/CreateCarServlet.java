package br.com.example.servlet;


import br.com.example.dao.CarDao;
import br.com.example.model.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/create-car")
public class CreateCarServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        String name = req.getParameter("car-name");
        String color = req.getParameter("color");

        CarDao carDao = new CarDao();

        if (id.equals("")) {

            Car car = new Car(name, color);
            carDao.createCar(car);

        } else {

            Car car = new Car(id, name, color);
            carDao.updateCar(car);

        }

        String scheme = req.getScheme(); // http
        String serverName = req.getServerName(); // localhost
        int serverPort = req.getServerPort(); // 8080
        String contextPath = req.getContextPath();
        String rota = "/find-all-cars";

        String finalRout = scheme + "://" + serverName + ":" + serverPort + contextPath + rota;

        resp.sendRedirect(finalRout);

    }

}
