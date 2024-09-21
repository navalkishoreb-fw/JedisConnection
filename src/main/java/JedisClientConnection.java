import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;

public class JedisClientConnection {
    private static final Logger logger = LoggerFactory.getLogger(JedisClientConnection.class);

    public static void main(String[] args) {


        try (Jedis jedis = new Jedis("localhost", 6379)) {
            // Check the connection
            String response = jedis.ping();
            logger.info("Connection to server: {}", response);

            // Set a key-value pair
            jedis.set("key", "value");
            logger.info("Stored key: key, value: {}", jedis.get("key"));

            // Perform other operations (if necessary)
            // Example: Increment a counter
            jedis.incr("counter");
            logger.info("Counter value:  {}", jedis.get("counter"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
