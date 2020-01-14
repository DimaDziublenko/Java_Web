import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class PetRequestTest {

    private static Logger logger = Logger.getLogger(PetRequestTest.class);
    private PetRequest request;
    private Pet pet;

    @BeforeClass
    public void data() {
        request = new PetRequest();
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
        }finally {
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
