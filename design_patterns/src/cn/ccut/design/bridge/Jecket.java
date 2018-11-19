package cn.ccut.design.bridge;

/**
 * ConctreteImplementor
 * @author zhipeng_Tong
 */
public class Jecket extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿马甲");
    }
}
