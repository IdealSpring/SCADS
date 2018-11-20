package cn.ccut.design.visitor;

/**
 * ConcreteVisitor
 *
 * @author zhipeng_Tong
 */
public class Success extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(String.format("男人 成功时，背后多半有一个伟大的女人。"));
    }

    @Override
    public void getWomanReslt(Woman woman) {
        System.out.println(String.format("女人 成功时，背后大多有个不成功的男人。"));
    }
}
