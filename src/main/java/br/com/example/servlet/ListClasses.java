package br.com.example.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

@WebServlet("/ListClasses")
public class ListClasses extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/plain");

        ClassLoader cl = Thread.currentThread().getContextClassLoader();
//
//        while (cl != null) {
//
//            response.getWriter().println("ClassLoader: " + cl);
//            Enumeration<URL> urls = cl.getResources("");
//
//            while (urls.hasMoreElements()) {
//                response.getWriter().println("  Resource: " + urls.nextElement());
//            }
//
//            cl = cl.getParent();
//
//        }


        while (cl != null) {

            response.getWriter().println("ClassLoader: " + cl);

            if (cl instanceof java.net.URLClassLoader) {
                URL[] urls = ((java.net.URLClassLoader) cl).getURLs();
                for (URL url : urls) {
                    response.getWriter().println("  URL: " + url);
                }
            } else {
                response.getWriter().println("  (Unknown ClassLoader type)");
            }

            cl = cl.getParent();

        }

    }

}
