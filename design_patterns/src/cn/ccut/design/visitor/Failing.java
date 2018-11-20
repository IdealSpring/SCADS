package cn.ccut.design.visitor;

/**
 * ConcreteVisitor
 *
 * @author zhipeng_Tong
 */
public class Failing extends Action {
    @Override
    public void getManResult(Man man) {
        System.out.println(String.format("男人 失败时，背后多半有一个不伟大的女人。"));
    }

    @Override
    public void getWomanReslt(Woman woman) {
        System.out.println(String.format("女人 失败时，背后大多有个成功的男人。"));
    }
}
