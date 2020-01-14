import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Objects;

public class PetRequest {

    private final CloseableHttpClient client = HttpClients.createDefault();
    private String uri = "https://petstore.swagger.io/v2/pet/";
    private static Logger logger = Logger.getLogger(PetRequest.class);

    public int get(int id) throws IOException {
        try (CloseableHttpResponse response = client.execute(new HttpGet(uri + id))) {
            HttpEntity entity = response.getEntity();
            logger.info(entity.getContentType());
            if (!Objects.isNull(entity)) {
                logger.info(EntityUtils.toString(entity));
            }
            return response.getStatusLine().getStatusCode();
        }
    }

    public int post(Pet pet) throws IOException {
        HttpPost post = new HttpPost(uri);
        post.addHeader("accept", "application/json");
        post.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder().append("{ \"id\": " + pet.getId() + ", \"name\": \"" + pet.getName() + ", \"category\": { \"id\": " + pet.getCategoryId() + ", \"name\": \"" + pet.getCategoryName() + "\" }, \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"animals\" } ], \"status\": \"" + pet.getStatus() + "\"}");
        post.setEntity(new StringEntity(json.toString()));
        try (CloseableHttpResponse response = client.execute(post)) {
            logger.info(EntityUtils.toString(response.getEntity()));
            return response.getStatusLine().getStatusCode();
        }
    }

    public int put(Pet pet) throws IOException {
        HttpPut put = new HttpPut(uri);
        put.addHeader("accept", "application/json");
        put.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder().append("{ \"id\": " + pet.getId() + ", \"name\": \"" + pet.getName() + ", \"category\": { \"id\": " + pet.getCategoryId() + ", \"name\": \"" + pet.getCategoryName() + "\" }, \"photoUrls\": [ \"string\" ], \"tags\": [ { \"id\": 0, \"name\": \"animals\" } ], \"status\": \"" + pet.getStatus() + "\"}");
        put.setEntity(new StringEntity(json.toString()));
        try (CloseableHttpResponse response = client.execute(put)) {
            logger.info(EntityUtils.toString(response.getEntity()));
            return response.getStatusLine().getStatusCode();
        }
    }

    public int delete(int id) throws IOException {
        HttpDelete delete = new HttpDelete(uri + id);
        delete.addHeader("accept", "application/json");
        try (CloseableHttpResponse response = client.execute(delete)) {
            return response.getStatusLine().getStatusCode();
        }
    }

    public void close() throws IOException {
        client.close();
    }
}
