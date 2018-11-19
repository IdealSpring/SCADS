package cn.ccut.design.interpreter;

/**
 * TerminalExpression
 *
 * @author zhipeng_Tong
 */
public class Scale extends  Expression {    // 音阶
    @Override
    public void excute(String key, double value) throws Exception {
        String scale = "";

        switch ((int)value) {
            case 1:
                scale = "低音";
                break;
            case 2:
                scale = "中音";
                break;
            case 3:
                scale = "高音";
                break;
            default:
                throw new Exception("输入有误！");
        }

        System.out.print(scale + " ");
    }
}
