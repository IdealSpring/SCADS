package cn.ccut.simplefactory;

/**
 * 简单工厂实现
 */
public class OperationFactory {
    public static Operation createOperate(String operate) throws Exception {
        Operation oper = null;

        switch (operate) {
            case "+":
                oper = new OperationAdd();
                break;
            case "-":
                oper = new OperationSubtraction();
                break;
            default:
                throw new Exception("no search operate!");
        }

        return oper;
    }
}
