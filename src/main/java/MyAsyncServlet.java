import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@WebServlet(value = "/async", asyncSupported = true)
public class MyAsyncServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            System.out.println("esperando...");
            Thread.sleep(50000);
            System.out.println("saindo");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        AsyncContext ac = req.startAsync();
        ac.addListener(new Async());
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(0);
        executor.execute(new MyAsyncService(ac, resp));
        executor.shutdown();
    }
}

class MyAsyncService implements Runnable {
    AsyncContext ac;
    HttpServletResponse response;
    public MyAsyncService(AsyncContext ac, HttpServletResponse resp) throws IOException {
        this.ac = ac;
        this.response = resp;

    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            System.out.println("Processando assincronamente - " + i);

        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><head>");
            out.println("<title> MyServlet Async</title>");
            out.println("</head><body>");
            out.println("<h1>The process has finished! </h1>");
            out.println("</body></html>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        ac.complete();
    }
}

class Async implements AsyncListener {

    @Override
    public void onComplete(AsyncEvent event) throws IOException {
        System.out.println("Finalizando Async Request.");
    }

    @Override
    public void onTimeout(AsyncEvent event) throws IOException {
        System.out.println("Timeout Async Request.");
    }

    @Override
    public void onError(AsyncEvent event) throws IOException {
        System.out.println("Error Async Request.");
    }

    @Override
    public void onStartAsync(AsyncEvent event) throws IOException {

    }
}

