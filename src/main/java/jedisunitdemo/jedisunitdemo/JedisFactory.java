package jedisunitdemo.jedisunitdemo;

import redis.clients.jedis.Jedis;

public class JedisFactory {
    public Jedis build(String host, int port, int timeout) {
        return new Jedis(host, port, timeout);
    }
}
