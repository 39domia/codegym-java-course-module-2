package animal;

public class Chicken extends Animal implements Edible {
    private String name;

    public Chicken(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void howToEat() {
        System.out.println("Chicken could be fried");
    }

    @Override
    public void makeSound() {
        System.out.println(this.getName() + " cuc tac");
    }
}
