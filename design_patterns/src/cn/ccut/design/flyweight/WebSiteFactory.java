package cn.ccut.design.flyweight;

import java.util.HashMap;

/**
 * FlywightFactory
 * @author zhipeng_Tong
 */
public class WebSiteFactory {
    private HashMap<String, WebSite> map = new HashMap<>();

    public WebSite getWebSiteCategory(String key) {
        WebSite webSite;
        if ((webSite = map.get(key)) == null)
            map.put(key, (webSite = new ConcreteWebSite(key)));

        return webSite;
    }

    public int getWebSiteCount() {
        return map.size();
    }
}
