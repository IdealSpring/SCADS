package cn.ccut.design.builder;

public class Client {
    public static void main(String[] args) {
        PersonDirector director = new PersonDirector();

        PersonThinBuilder ptb = new PersonThinBuilder();
        Person person = director.constructPerson(ptb);
        System.out.println(person);

        PersonFatBuilder pfb = new PersonFatBuilder();
        Person person1 = director.constructPerson(pfb);
        System.out.println(person1);
    }

}
