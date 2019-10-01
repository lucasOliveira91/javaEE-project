import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import java.io.Serializable;

@Named
@SessionScoped
    public class Use implements Serializable {
    private String name;
    private String password;
    private String status = "Not logged";

    public void login() {
            status = "Login successful";

    }

    public void checkFormat(AjaxBehaviorEvent evt) {
        System.out.println(evt);
    }

    public void process() throws InterruptedException {
//        Thread.sleep(20000);
        System.out.println(this.name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}