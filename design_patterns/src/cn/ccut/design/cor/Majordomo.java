package cn.ccut.design.cor;

/**
 * ConcreteHandler
 *
 * @author zhipeng_Tong
 */
public class Majordomo extends Manager {    // 总监
    public Majordomo(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Requset requset) {
        if (requset.getRequestType().equals("请假") && requset.getNumber() <= 5) {
            System.out.println(String.format("%s:%s 数量%s 被批准",
                    name, requset.getRequsetContent(), requset.getNumber()));
        } else {
            if (superior != null)
                superior.requestApplications(requset);
        }
    }
}
