package cn.ccut.learnrecond.day_12;

public abstract class Decorator implements Phone {
    private Phone phone;

    public Decorator(Phone phone) {
        this.phone = phone;
    }

    @Override
    public void call() {
        if (phone != null)
            phone.call();
    }
}
