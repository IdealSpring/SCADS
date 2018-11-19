package cn.ccut.design.command;

/**
 * ConcreteCommand
 * @author zhipeng_Tong
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void execute() {
        receiver.execute();
    }
}
