package cn.ccut.command;

/**
 * Command
 * @author zhipeng_Tong
 */
public abstract class Command {
    protected Receiver receiver;  // 命令真正的执行者

    public Command(Receiver receiver) {
        this.receiver = receiver;
    }

    public abstract void execute(); // 延迟到子类实现
}
