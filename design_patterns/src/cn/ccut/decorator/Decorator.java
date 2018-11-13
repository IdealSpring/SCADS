package cn.ccut.decorator;

/**
 * Decorator抽象类，实现了(Component接口的)Person
 * @author zhipeng_Tong
 */
public abstract class Decorator implements Person {
    protected Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public void speak() {
        if (person != null)
            person.speak();
    }
}
