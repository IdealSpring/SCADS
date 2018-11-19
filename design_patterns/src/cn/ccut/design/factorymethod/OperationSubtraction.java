package cn.ccut.design.factorymethod;

/**
 * 减法操作
 */
public class OperationSubtraction extends Operation {
    @Override
    public double getResult(double t1, double t2) {
        return t1 - t2;
    }
}
