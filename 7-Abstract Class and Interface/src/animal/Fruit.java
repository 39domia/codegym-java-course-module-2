package animal;

public abstract class Fruit implements Edible {
}

class Orange extends Fruit {

    @Override
    public void howToEat() {
        System.out.println("Orange could be juiced");
    }
}

class Apple extends Fruit {

    @Override
    public void howToEat() {
        System.out.println("Apple could be slided");
    }
}
