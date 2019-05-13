import com.dylan.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(locations = "classpath:application.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSave extends RedisUtil {

    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Test
    public void testRedis(){
        jedisConnectionFactory.setDatabase(13);
        hset("eqq","dadada","dad");
    }



}
