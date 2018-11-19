package cn.ccut.design.flyweight;

public class Client {
    public static void main(String[] args) {
        WebSiteFactory factory = new WebSiteFactory();

        WebSite fx = factory.getWebSiteCategory("产品展示");
        fx.use(new User("小明"));

        WebSite fy = factory.getWebSiteCategory("产品展示");
        fx.use(new User("大明"));

        WebSite fl = factory.getWebSiteCategory("博客");
        fx.use(new User("哆啦A梦"));

        System.out.println(String.format("网站总数：%s", factory.getWebSiteCount()));
    }
}
