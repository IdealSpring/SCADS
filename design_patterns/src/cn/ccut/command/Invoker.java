package cn.ccut.command;

/**
 * Invoker
 * @author zhipeng_Tong
 */
public class Invoker {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        command.execute();
    }
}
