package lesson5;

public class TestLesson5 {

    public static void main(String[] args) {
        Person[] personsArray = new Person[5];
        personsArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "892312312", 30000, 30);
        personsArray[1] = new Person("Petrov Ivan", "Cleaner", "Petrov@mailbox.com",
                "892312316", 130000, 25);
        personsArray[2] = new Person("Kuznetsov Ivan", "Manager", "Kuznetsov@mailbox.com",
                "892312317", 330000, 30);
        personsArray[3] = new Person("Sidorov Ivan", "Sub boss", "Sidorov@mailbox.com",
                "892312318", 430000, 45);
        personsArray[4] = new Person("Fedorov Ivan", "Boss", "Fedorov@mailbox.com",
                "892312319", 530000, 50);

        for (Person person : personsArray) {
            if (person.getAge() > 40) {
                person.printInfo();
            }
        }

    }

}
