package cn.ccut.design.visitor;

/**
 * Visitor
 *
 * @author zhipeng_Tong
 */
public abstract class Action {
    // 得到男人结论或反映
    public abstract void getManResult(Man man);

    // 得到女人结论或反映
    public abstract void getWomanReslt(Woman woman);
}
