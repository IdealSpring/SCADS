package cn.ccut.learnrecond02.day_05;

import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class JedisDemo {
    @Test
    public void test() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        Transaction multi = jedis.multi();
        multi.mset("k1", "v1", "k2", "v2");
//        multi.discard();
        multi.exec();


    }

    @Test
    public void test01() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        System.out.println(jedis.ping());

        // key-value
//        jedis.set("k1", "v1");
//        jedis.set("k2", "v2");
//        jedis.set("k3", "v3");
//        System.out.println(jedis.get("k1"));
//        System.out.println(jedis.get("k2"));
//        System.out.println(jedis.get("k3"));
//        System.out.println("--------------------------");
//        Set<String> keys = jedis.keys("*");
//        for (String s : keys)
//            System.out.println(s);
//        System.out.println(jedis.exists("k1"));
//        System.out.println(jedis.ttl("k1"));
//        jedis.mset("str1", "v1", "str2", "v2", "str3", "v3");
//        List<String> mget = jedis.mget("str1", "str2", "str3");
//        System.out.println(mget);
//        jedis.append("k1", "myredis");

        // list
//        jedis.lpush("llist", "1", "2", "3", "4", "5");
//        jedis.rpush("llist", "1", "2", "3", "4", "5");
//        List<String> llist = jedis.lrange("llist", 0, -1);
//        System.out.println(llist);

        // set
//        jedis.sadd("set1", "v1");
//        jedis.sadd("set1", "v2");
//        jedis.sadd("set1", "v3");
//        Set<String> set1 = jedis.smembers("set1");
//        System.out.println(set1);
//        jedis.srem("set1", "v1");

        // hash
//        jedis.hset("hash1", "name", "李四");
//        System.out.println(jedis.hget("hash1", "name"));
//        HashMap<String, String> map = new HashMap<>();
//        map.put("name", "lisi");
//        map.put("age", "12");
//        map.put("address", "changchun");
//        jedis.hmset("hash2", map);

//        List<String> hmget = jedis.hmget("hash2", "name", "age", "address");
//        System.out.println(hmget);

        // zset
        jedis.zadd("zset", 100, "liming");
        jedis.zadd("zset", 90, "lihua");
        jedis.zadd("zset", 80, "xiaoming");
        Set<String> zset = jedis.zrange("zset", 0, -1);
        System.out.println(zset);
    }
}
