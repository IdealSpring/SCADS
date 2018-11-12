package cn.ccut.builder;

public class PersonDirector {
    public Person constructPerson(PersonBuilder builder) {
        builder.buildHead();
        builder.buildBody();
        builder.buildFoot();

        Person person = builder.getPerson();
        return person;
    }
}
