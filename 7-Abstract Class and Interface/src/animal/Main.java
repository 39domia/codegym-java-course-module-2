package animal;

public class Main {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];
        animals[0] = new Tiger("Tiger1");
        animals[1] = new Chicken("Chicken1");
        for (Animal animal : animals) {
            animal.makeSound();

            if (animal instanceof Chicken) {
                Edible edibler = (Chicken) animal;
                edibler.howToEat();
            }
        }

        Fruit[] fruits = new Fruit[2];
        fruits[0] = new Orange();
        fruits[1] = new Apple();
        for (Fruit fruit : fruits) {
            fruit.howToEat();
        }
    }
}
