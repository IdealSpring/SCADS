package cn.ccut.design.state;
/**
 * ConcreteState
 *
 * @author zhipeng_Tong
 */
public class EveningState extends State {
    @Override
    public void writeProgram(Work work) {
        if (work.isFinishWork()) {
            work.setState(new RestState());
            work.writeProgram();
        } else {
            if (work.getHour() < 21) {
                System.out.println(String.format("当前时间：%s 点 加班哈，及其疲劳", work.getHour()));
            } else {
                work.setState(new SleepingState());
                work.writeProgram();
            }
        }
    }
}
