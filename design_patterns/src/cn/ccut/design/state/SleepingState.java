package cn.ccut.design.state;
/**
 * ConcreteState
 *
 * @author zhipeng_Tong
 */
public class SleepingState extends State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间：%s 点 不行了，睡着了", work.getHour()));
    }
}
