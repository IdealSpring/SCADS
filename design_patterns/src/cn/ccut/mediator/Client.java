package cn.ccut.mediator;

public class Client {
    public static void main(String[] args) {
        UnitedNationsSecurityConcil concil = new UnitedNationsSecurityConcil();

        USA usa = new USA(concil);
        Iraq iraq = new Iraq(concil);

        concil.setUsa(usa);
        concil.setIraq(iraq);

        String usaSpeak = "不准研制核武器，否则发动战争。";
        System.out.println(String.format("美国发送消息：%s", usaSpeak));
        usa.declare(usaSpeak);

        String iraqSpeak = "我们没有研制核武器，不怕你。。";
        System.out.println(String.format("伊拉克发送消息：%s", iraqSpeak));
        iraq.declare(iraqSpeak);
    }
}
