package cn.ccut.factorymethod;

public class AddFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationAdd();
    }
}
