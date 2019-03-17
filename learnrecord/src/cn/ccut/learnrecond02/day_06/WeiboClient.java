package cn.ccut.learnrecond02.day_06;

import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.Scanner;

/**
 * 微博客户端
 */
public class WeiboClient {
    private Scanner sc = new Scanner(System.in);
    private static Jedis jedis;
    private String loginUserid;

    static {
        jedis = new Jedis("111.116.20.105", 6379);
        System.out.println(jedis.ping());
    }

    public static void main(String[] args) throws Exception {
        WeiboClient weiboClient = new WeiboClient();
        String select = "1";

        while (select != "0") {
            Thread.sleep(200);

            System.out.println("1.注册； 2.登录； 3.发博客");
            System.out.print("选择：");
            select = weiboClient.sc.nextLine();

            switch (select) {
                case "1":
                    weiboClient.register();
                    break;
                case "2":
                    weiboClient.login();
                    break;
                case "3":
                    weiboClient.postBlog();
                    break;

            }
        }


    }

    /**
     * key设计：
     * incr global:postid
     * post:postid:1:timestamp 2019-3-11 18:22:21
     * post:postid:1:userid: 2
     * post:postid:content "good good study, day day up"
     *
     */
    private void postBlog() throws Exception {
        if (loginUserid == null) {
            System.err.println("用户未登录");
            return;
        }

        System.out.print("待发布的博客内容：");
        String content = sc.nextLine();

        Long incr = jedis.incr("global:postid");
        jedis.set("post:postid:" + String.valueOf(incr) + ":timestamp", new Date().toString());
        jedis.set("post:postid:" + String.valueOf(incr) + ":userid", loginUserid);
        jedis.set("post:postid:" + String.valueOf(incr) + ":content", content);

        System.out.println("发布成功");
    }

    /**
     * key设计原则
     * 表名:主键名：主键值：字段
     *
     * value值
     */
    private void login() throws Exception {
        System.out.print("用户名：");
        String username = sc.nextLine();
        System.out.print("密码：");
        String password = sc.nextLine();

        String userid = jedis.get("user:username:" + username + ":userid");
        if (userid == null) {
            System.err.println("用户不存在");
            return;
        }

        String passwd = jedis.get("user:userid:" + userid + ":password");
        if (!passwd.equals(password)) {
            System.err.println("密码错误");
            return;
        }
        loginUserid = userid;
        System.out.println("登录成功！");
    }

    /**
     * 用户键设计
     * user:userid:[1,n]:username xxx
     * user:userid:[1,n]:password xxx
     *
     * 查询用户名，冗余设计
     * global:userid
     *
     * user:username:xxx:userid xxx
     */
    public void register() throws Exception {
        System.out.print("用户名：");
        String username = sc.nextLine();
        System.out.print("密码：");
        String password = sc.nextLine();
        System.out.print("邮箱：");
        String email = sc.nextLine();

        if (username == null || "".equals(username)) {
            System.err.println("用户名为空");
            return;
        }


        String userid = jedis.get("user:username:" + username + ":userid");
        if (userid != null || "".equals(userid)) {
            System.err.println("用户名已经被注册");
            return;
        }

        Long globalUserid = jedis.incr("global:userid");

        jedis.set("user:userid:" + String.valueOf(globalUserid) + ":username", username);
        jedis.set("user:userid:" + String.valueOf(globalUserid) + ":password", password);
        jedis.set("user:userid:" + String.valueOf(globalUserid) + ":email", email);

        jedis.set("user:username:" + username + ":userid", String.valueOf(globalUserid));

        System.out.println(globalUserid + "-" + username + "-" + email + "-注册成功！");
    }
}
