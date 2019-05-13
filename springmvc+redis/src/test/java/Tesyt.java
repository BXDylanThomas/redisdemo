import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@ContextConfiguration(locations = { "classpath:application.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Tesyt {

    @Autowired
   private static ApplicationContext applicationContext=new ClassPathXmlApplicationContext("application.xml");
   @Test
    public void test() {
        RedisTemplate redisTemplate= (RedisTemplate) applicationContext.getBean("redisTemplate");
        redisTemplate.rename("a","c");

    }
}
