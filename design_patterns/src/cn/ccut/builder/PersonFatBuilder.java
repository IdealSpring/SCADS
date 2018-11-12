package cn.ccut.builder;

public class PersonFatBuilder implements PersonBuilder {
    private Person person;

    public PersonFatBuilder() {
        person = new Person();
    }

    @Override
    public void buildHead() {
        person.setHead("头部");
    }

    @Override
    public void buildBody() {
        person.setBody("胖胖的身体");
    }

    @Override
    public void buildFoot() {
        person.setFoot("脚部");
    }

    @Override
    public Person getPerson() {
        return person;
    }
}
