package br.com.example.servlet.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "EndSession", urlPatterns = {"/end-session"})
public class EndSession extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {

        HttpSession httpSession = httpServletRequest.getSession(false);

        if (httpSession != null) {

            httpSession.invalidate();

            Cookie cookie = new Cookie("JSESSIONID", "");
            cookie.setMaxAge(0);
            httpServletResponse.addCookie(cookie);

        }

        httpServletRequest.getRequestDispatcher("/session-end.jsp").forward(httpServletRequest, httpServletResponse);

    }

}
