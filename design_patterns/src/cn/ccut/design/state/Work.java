package cn.ccut.design.state;

/**
 * Context
 *
 * @author zhipeng_Tong
 */
public class Work {
    private State currentState;
    private double hour;
    private boolean isFinishWork;

    // 初始化上午工作状态
    public Work() {
        this.currentState = new ForenoonState();
    }

    public State getState() {
        return currentState;
    }

    public void setState(State state) {
        this.currentState = state;
    }

    public double getHour() {
        return hour;
    }

    public void setHour(double hour) {
        this.hour = hour;
    }

    public boolean isFinishWork() {
        return isFinishWork;
    }

    public void setFinishWork(boolean finishWork) {
        isFinishWork = finishWork;
    }

    public void writeProgram() {
        currentState.writeProgram(this);
    }
}
