package cn.ccut.design.state;
/**
 * ConcreteState
 *
 * @author zhipeng_Tong
 */
public class RestState extends State {
    @Override
    public void writeProgram(Work work) {
        System.out.println(String.format("当前时间：%s 点 下班回家了！", work.getHour()));
    }
}
