package cn.ccut.design.factorymethod;

public class SubtractionFactory implements Factory {
    @Override
    public Operation createOperation() {
        return new OperationSubtraction();
    }
}
