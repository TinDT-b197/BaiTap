public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Meo");
        System.out.println(cat);
        cat.greets();
        Dog dog = new Dog("Mun");
        System.out.println(dog);
        dog.greets();

    }
}