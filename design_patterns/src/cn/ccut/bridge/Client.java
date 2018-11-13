package cn.ccut.bridge;

public class Client {
    public static void main(String[] args) {

        Person man = new Man();

        Person lady = new Lady();

        Clothing jacket = new Jecket();

        Clothing trouser = new Trouser();

        jacket.personDressCloth(man);
        trouser.personDressCloth(man);

        jacket.personDressCloth(lady);
        trouser.personDressCloth(lady);
    }
}
