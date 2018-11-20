package cn.ccut.design.cor;

/**
 * ConcreteHandler
 *
 * @author zhipeng_Tong
 */
public class CommonManager extends Manager {    // 经理
    public CommonManager(String name) {
        super(name);
    }

    @Override
    public void requestApplications(Requset requset) {
        if (requset.getRequestType().equals("请假") && requset.getNumber() <= 2) {
            System.out.println(String.format("%s:%s 数量%s 被批准",
                    name, requset.getRequsetContent(), requset.getNumber()));
        } else {
            if (superior != null)
                superior.requestApplications(requset);
        }
    }
}
