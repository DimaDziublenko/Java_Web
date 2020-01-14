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

public class StoreRequest {

    private final CloseableHttpClient client = HttpClients.createDefault();
    private static Logger logger = Logger.getLogger(StoreRequest.class);
    private String uri = "https://petstore.swagger.io/v2/store/order/";

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

    public int post(Order order) throws IOException {
        HttpPost post = new HttpPost(uri);
        post.addHeader("accept", "application/json");
        post.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder().append("{ \"id\": " + order.getId() + ", \"petId\": " + order.getPetId() + ", \"quantity\": " + order.getQuantity() + ", \"shipDate\": \"2020-01-13T21:01:04.750Z\", \"status\": \"" + order.getStatus() + "\", \"complete\": true}");
        post.setEntity(new StringEntity(json.toString()));
        try (CloseableHttpResponse response = client.execute(post)) {
            logger.info(EntityUtils.toString(response.getEntity()));
            return response.getStatusLine().getStatusCode();
        }
    }

    public int put(Order order) throws IOException {
        HttpPut put = new HttpPut(uri);
        put.addHeader("accept", "application/json");
        put.addHeader("content-type", "application/json");
        StringBuilder json = new StringBuilder().append("{ \"id\": " + order.getId() + ", \"petId\": " + order.getPetId() + ", \"quantity\": " + order.getQuantity() + ", \"shipDate\": \"2020-01-13T21:01:04.750Z\", \"status\": \"" + order.getStatus() + "\", \"complete\": true}");
        put.setEntity(new StringEntity(json.toString()));
        try (CloseableHttpResponse response = client.execute(put);) {
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
