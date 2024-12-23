package br.com.example.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "GetSession", urlPatterns = { "/get-session" })
public class GetSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        HttpSession httpSession = httpServletRequest.getSession();

        httpSession.setAttribute("sessionId", httpSession.getId());
        httpSession.setAttribute("isNewSession", httpSession.isNew());

        httpServletRequest.getRequestDispatcher("/session-get.jsp").forward(httpServletRequest, httpServletResponse);

    }

}
