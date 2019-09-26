import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/account", initParams = {
        @WebInitParam(name = "type", value = "checking")
})
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