import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class BankServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Obtendo parametro dipacher " + req.getParameter("tx"));

        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><head>");
            out.println("<title>  - - MyServlet</title>");
            out.println("</head><body>");
            out.println("<h1>"+ req.getParameter("tx") +"</h1>");
            out.println("</body></html>");
        }
    }
}
