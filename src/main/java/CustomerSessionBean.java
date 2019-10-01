import javax.ejb.Stateless;
import javax.inject.Named;
import java.util.Arrays;
import java.util.List;

@Stateless
@Named
public class CustomerSessionBean {

    public List<Name> getCustomerNames() {
        return Arrays.asList(new Name("Lucas"), new Name("Jessica"));
    }
}


