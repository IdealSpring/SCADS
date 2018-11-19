package cn.ccut.design.state;

/**
 * ConcreteState
 *
 * @author zhipeng_Tong
 */
public class ForenoonState extends State {  // 上午工作状态
    @Override
    public void writeProgram(Work work) {
        if (work.getHour() < 12) {
            System.out.println(String.format("当前时间：%s 点 上午工作，精神百倍", work.getHour()));
        } else {
            work.setState(new NoonState());
            work.writeProgram();
        }
    }
}
