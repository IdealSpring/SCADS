package cn.ccut.design.bridge;

/**
 * ConctreteImplement
 * @author zhipeng_Tong
 */
public class Trouser extends Clothing {
    @Override
    public void personDressCloth(Person person) {
        System.out.println(person.getType() + "穿裤子");
    }
}
