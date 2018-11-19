package cn.ccut.design.abstractfactory;

public class WhiteAnimalFactory implements IAnimalFactory {
    @Override
    public IDog createDog() {
        return new WhiteDog();
    }

    @Override
    public ICat createCat() {
        return new WhiteCat();
    }
}
