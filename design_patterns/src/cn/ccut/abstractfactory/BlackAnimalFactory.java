package cn.ccut.abstractfactory;

public class BlackAnimalFactory implements IAnimalFactory{
    @Override
    public IDog createDog() {
        return new BlackDog();
    }

    @Override
    public ICat createCat() {
        return new BlackCat();
    }
}
