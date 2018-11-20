package cn.ccut.design.cor;

/**
 * ConcreteHandler
 *
 * @author zhipeng_Tong
 */
public class GeneralManager extends Manager {   // 总经理
    public GeneralManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Requset requset) {
        if (requset.getRequestType().equals("请假")) {
            System.out.println(String.format("%s:%s 数量%s 被批准",
                    name, requset.getRequsetContent(), requset.getNumber()));
        } else if (requset.getRequestType().equals("加薪") && requset.getNumber() <= 500) {
            System.out.println(String.format("%s:%s 数量%s 被批准",
                    name, requset.getRequsetContent(), requset.getNumber()));
        } else if (requset.getRequestType().equals("加薪") && requset.getNumber() > 500) {
            System.out.println(String.format("%s:%s 数量%s 再说吧！",
                    name, requset.getRequsetContent(), requset.getNumber()));
        } else {
            System.out.println("你走吧！！！");
        }
    }
}
