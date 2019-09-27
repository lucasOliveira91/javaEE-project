import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A servlet is a web component hosted in a servlet container and generates dynamic
 * content.
 */
//@WebServlet(value = "/account", initParams = {
//        @WebInitParam(name = "type", value = "checking")
//})
//@ServletSecurity(
//        value = @HttpConstraint(rolesAllowed = {"R1"}),
//        httpMethodConstraints = {
//                @HttpMethodConstraint(value = "GET", rolesAllowed = "R2"),
//                @HttpMethodConstraint(value = "POST", rolesAllowed = {"R3", "R4"})
//        }
//)
@WebServlet(value = "/account")
public class AccountServlet extends HttpServlet {

    String type = null;
    @Override
    public void init(ServletConfig config) throws ServletException {
        type = config.getInitParameter("type");
        System.out.println(type);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = req.getServletContext();

        servletContext.setAttribute("cidade", "Brasilia");
        String tx = req.getParameter("tx");
//        req.getRequestDispatcher("bank").forward(req, resp);
//        resp.sendRedirect("bank");
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head>");
            out.println("<title>"+ tx +" - - MyServlet</title>");
            out.println("</head><body>");
            out.println("<h1>My First Servlet</h1>");
            out.println("</body></html>");
        }
    }
}
