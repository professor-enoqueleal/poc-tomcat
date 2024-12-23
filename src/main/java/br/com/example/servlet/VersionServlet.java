package br.com.example.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "VersionServlet", urlPatterns = { "/version" })
public class VersionServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String serverIP = req.getLocalAddr();

        // Configurar a resposta
        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8");

        // Escrever o endereço IP do servidor na resposta
        resp.getWriter().write("server ip: " + serverIP);

    }

}
