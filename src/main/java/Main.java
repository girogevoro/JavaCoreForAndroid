public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        System.out.println("cat run 100 " + cat.run(100));
        System.out.println("cat run 250 " + cat.run(250));
        System.out.println("cat swim 5 " + cat.swim(5));

        cat.setRunDistance(300);
        cat.setSwimDistance(10);
        System.out.println("cat run 250(set 300) " + cat.run(250));
        System.out.println("cat swim 5(set 10) " + cat.swim(5));
        System.out.println();

        Dog dog = new Dog();
        System.out.println("dog run 250 " + dog.run(250));
        System.out.println("dog run 550 " + dog.run(550));
        System.out.println("dog swim 10 " + dog.swim(10));
        System.out.println("dog swim 15 " + dog.swim(15));
        dog.setRunDistance(600);
        dog.setSwimDistance(100);
        System.out.println("dog run 550(set 600) " + dog.run(550));
        System.out.println("dog swim 15(set 100) " + dog.swim(15));
        System.out.println();

        Animal[] animals = {new Cat(), new Cat(), new Cat(), new Cat(), new Cat(), new Dog(), new Dog()};

        Cat.printCount();
        Dog.printCount();
        Animal.printCount();

    }
}
