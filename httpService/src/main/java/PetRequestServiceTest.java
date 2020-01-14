import org.apache.log4j.Logger;

import org.apache.log4j.spi.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class PetRequestServiceTest {

    private static final Logger logger = Logger.getLogger(PetRequestServiceTest.class);
    private PetRequestService request;
    private Pet pet;

    @BeforeClass
    public void setUp() {
        request = new PetRequestService();
        pet = new Pet(1, 1, "Dogs", "Mike", "pending");
    }

    @Test
    public void petShouldBeAddCorrectly() throws IOException {
        try {
            assertEquals(404, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void statusCodeShouldBeError() throws IOException {
        try {
            if (404 == request.get(11111)) {
                logger.info("Pet with id: " + 11111 + " not found!");
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
                request.close();
        }
    }

    @Test
    public void petShouldBeUpdateCorrectly() throws IOException {
        try {
            assertEquals(200, request.post(pet));
            pet.setStatus("sold");
            pet.setName("Jack");
            assertEquals(200, request.post(pet));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petShouldBeGetCorrectly() throws IOException {
        try {
            assertEquals(404, request.get(1));
            assertEquals(200, request.post(pet));
            assertEquals(200, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }

    @Test
    public void petShouldBeDeleteCorrectly() throws IOException {
        try {
            assertEquals(200, request.post(pet));
            assertEquals(200, request.delete(1));
            assertEquals(404, request.get(1));
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            request.close();
        }
    }
}
