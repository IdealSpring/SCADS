package cn.ccut.design.interpreter;

/**
 * AbstractExpression:
 *      表达式类：Expression
 * @author zhipeng_Tong
 */
public abstract class Expression {  // 表达式
    // 解释器
    public void interpreter(PlayContext context) throws Exception {
        if (context.getText().length() == 0)
            return;
        else {
            String playKey = context.getText().substring(0, 1);
            context.setText(context.getText().substring(2));
            double playValue = Double.parseDouble(context.getText().
                    substring(0, context.getText().indexOf(" ")));
            context.setText(context.getText().substring(context.getText().indexOf(" ") + 1));

            excute(playKey, playValue);
        }
    }

    // 执行
    public abstract void excute(String key, double value) throws Exception;
}
