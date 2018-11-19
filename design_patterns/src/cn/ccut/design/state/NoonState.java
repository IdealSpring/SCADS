package cn.ccut.design.state;

/**
 * ConcreteState
 *
 * @author zhipeng_Tong
 */
public class NoonState extends State {  // 中午工作状态
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 13) {
            System.out.println(String.format("当前时间：%s 点 饿了，吃午饭；犯困，午休。", work.getHour()));
        } else {
            work.setState(new AfternoonState());
            work.writeProgram();
        }
    }
}
