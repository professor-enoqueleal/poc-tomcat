package br.com.example.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "InitSession", urlPatterns = { "/init-session" })
public class InitSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws ServletException, IOException {

        HttpSession httpSession = servletRequest.getSession(true);

        servletRequest.getSession().setAttribute("sessionId", httpSession.getId());
        servletRequest.getSession().setAttribute("isNewSession", httpSession.isNew());

        servletRequest.getRequestDispatcher("/session-init.jsp").forward(servletRequest, servletResponse);

    }


}
