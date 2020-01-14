import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class StoreRequestTest {

    private static Logger logger = Logger.getLogger(StoreRequestTest.class);
    private StoreRequest request;
    private Order order;

    @BeforeClass
    public void data() {
        request = new StoreRequest();
        order = new Order(1, 1, 1, "1/1/1", "placed", true);
    }

    @Test
    public void orderShouldBeAddCorrectly() throws IOException {
        try {
            assertEquals(404, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void orderShouldBeUpdateCorrectly() throws IOException {
        try {
            assertEquals(200, request.post(order));
            order.setQuantity(2);
            order.setShipDate("2/2/2");
            assertEquals(200, request.post(order));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void orderShouldBeGetCorrectly() throws IOException {
        try {
            assertEquals(404, request.get(1));
            assertEquals(200, request.post(order));
            assertEquals(200, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void orderShouldBeDeleteCorrectly() throws IOException {
        try {
            assertEquals(200, request.post(order));
            assertEquals(200, request.delete(1));
            assertEquals(404, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }
}
