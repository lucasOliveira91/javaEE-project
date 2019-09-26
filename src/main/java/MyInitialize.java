import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Set;

public class MyInitialize implements ServletContainerInitializer {

    /**
     * This method is launched when the application starts
     * @param c
     * @param ctx
     * @throws ServletException
     */
    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {

        /*
            Creating Servlet programmatically
         */
        ServletRegistration.Dynamic reg = ctx.addServlet("BankServlet", "BankServlet");
        reg.addMapping("/bank");
    }
}
