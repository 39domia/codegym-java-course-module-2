package animal;

public class Tiger extends Animal {
    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void makeSound() {
        System.out.println(this.getName() + " roarrr");

    }
}
