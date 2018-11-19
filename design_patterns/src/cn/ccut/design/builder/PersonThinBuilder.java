package cn.ccut.design.builder;

public class PersonThinBuilder implements PersonBuilder {
    private Person person;

    public PersonThinBuilder() {
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("头部");
    }

    @Override
    public void buildBody() {
        person.setBody("瘦瘦的身体");
    }

    @Override
    public void buildFoot() {
        person.setFoot("脚");
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
