package jedisunitdemo.jedisunitdemo;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Client;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Protocol;

@Service
public class JedisTestServiceImpl implements JedisTestService {

    @Override
    public void sendCommand() {
        JedisFactory jedisFactory = new JedisFactory();
        Jedis jedis = jedisFactory.build("localhost", 6379, 100);
        jedis.auth("test");
        //do something
        Client client = jedis.getClient();
        client.sendCommand(Protocol.Command.SET, "masterauth", "111111");
    }

    @Override
    public void test() {
        System.out.println("111");
    }
}
