package jedisunitdemo.jedisunitdemo;

import com.fiftyonred.mock_jedis.MockJedis;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JedisUnitDemoApplication.class)
public class JedisTestServiceImplTest {
    @Autowired
    private JedisTestService jedisTestService;
    @MockBean
    private JedisFactory jedisFactory;

    @Test
    public void sendCommand() {
        Jedis jedis = new MockJedis("test");
        when(jedisFactory.build(anyString(), anyInt(), anyInt())).thenReturn(jedis);

        //问题：我该如何打桩jedis.auth方法
        doReturn("OK").when(jedis).auth(anyString());
        jedisTestService.sendCommand();
    }

    @Test
    public void test1() {
        jedisTestService.test();
    }

}