package cn.ccut.simplefactory;

public class Client {
    public static void main(String[] args) throws Exception {
        Operation operateAdd = OperationFactory.createOperate("+");
        double result = operateAdd.getResult(1, 2);
        System.out.println("add result: " + result);

        Operation operateSubtraction = OperationFactory.createOperate("-");
        double result1 = operateSubtraction.getResult(5, 2);
        System.out.println("subtraction result: " + result1);
    }
}
