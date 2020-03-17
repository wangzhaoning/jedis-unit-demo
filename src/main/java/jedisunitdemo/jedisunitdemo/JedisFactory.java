package jedisunitdemo.jedisunitdemo;

import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

@Service
public class JedisFactory {
    public Jedis build(String host, int port, int timeout) {
        return new Jedis(host, port, timeout);
    }
}
