package resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;

@Path("orders")
public class OrderResource {

    @GET
    public List<Order> getAll(@QueryParam("start") int from) {
        return Arrays.asList(new Order("1234"), new Order("3331234"));
    }


    @GET
    @Path("{oid}")
    public Order getOrder(@PathParam("oid") int id) {
        return null;
    }
}
@XmlRootElement
class Order {
    public Order() {
    }

    private String numOrder;

    public Order(String numOrder) {

        this.numOrder = numOrder;
    }
}
