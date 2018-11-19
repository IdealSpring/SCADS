package cn.ccut.design.interpreter;

/**
 * TerminalExpression
 *
 * @author zhipeng_Tong
 */
public class Note extends Expression {  // 音韵
    @Override
    public void excute(String key, double value) throws Exception {
        String note = "";

        switch (key) {
            case "C":
                note = "1";
                break;
            case "D":
                note = "2";
                break;
            case "E":
                note = "3";
                break;
            case "F":
                note = "4";
                break;
            case "G":
                note = "5";
                break;
            case "A":
                note = "6";
                break;
            case "B":
                note = "7";
                break;
            default:
                throw new Exception("输入有误！");
        }

        System.out.print(note + " ");
    }
}
