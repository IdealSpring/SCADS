package cn.ccut.abstractfactory;

public class Client {
    public static void main(String[] args) {
        IAnimalFactory animalFactory = new BlackAnimalFactory();
        IDog dog = animalFactory.createDog();
        ICat cat = animalFactory.createCat();
        dog.describe();
        cat.describe();

        IAnimalFactory animalFactory1 = new WhiteAnimalFactory();
        IDog dog1 = animalFactory1.createDog();
        ICat cat1 = animalFactory1.createCat();
        dog1.describe();
        cat1.describe();
    }
}
