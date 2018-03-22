import org.junit.Assert;
import org.junit.Test;
import redis.clients.jedis.Jedis;

/**
 * @author jiang
 * @create 2018-02-25 20:16
 **/
public class commonTest {

    @Test
    public void test_redis_connect() {
        Jedis jedis = new Jedis("118.25.23.193", 6379);
        jedis.auth("123456");
        Assert.assertEquals(jedis.ping(),"PONG");
    }
}
