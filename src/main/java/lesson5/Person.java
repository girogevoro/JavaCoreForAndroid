package lesson5;

public class Person {
    private String fio;
    private String post;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Person(String fio, String post, String email, String telephone, int salary, int age) {
        this.fio = fio;
        this.post = post;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return String.format("fio: %s, post: %s, email: %s, telephone: %s, salary: %d, age: %d",
                fio, post, email, telephone, salary, age);
    }

    public int getAge() {
        return age;
    }
}
