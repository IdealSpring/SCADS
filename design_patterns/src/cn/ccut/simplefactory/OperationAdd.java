package cn.ccut.simplefactory;

/**
 * 加法操作
 */
public class OperationAdd extends Operation {
    @Override
    public double getResult(double t1, double t2) {
        return t1 + t2;
    }
}
