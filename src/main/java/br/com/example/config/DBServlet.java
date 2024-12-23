package br.com.example.config;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.sql.Connection;
import java.sql.Statement;

@WebServlet(
        urlPatterns = {"/init"},
        loadOnStartup = 1
)
public class DBServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {

        try {

            Connection connection = ConnectionPoolConfig.getConnection();

            Statement statement = connection.createStatement();

            String sql = "CREATE TABLE CAR(ID INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), COLOR VARCHAR(255));";

            statement.executeUpdate(sql);

            statement.close();

            connection.close();

            System.out.println("Success on create table CAR!");

        } catch (Exception e) {

            throw new ServletException("Failed to initialize database", e);

        }

    }

}
