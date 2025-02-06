import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Person {

    private final String name;
    private final String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Person)) {
            return false;
        } else {
            Person other = (Person) obj;
            return Objects.equals(name, other.name)
                    && Objects.equals(address, other.address);
        }
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", address=" + address + "]";
    }

    // standard getters
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

}

public class HelloWorld {

    private static final String MONDAY = "Monday";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");

        for (int i = 0; i < names.size(); i++) {
            System.out.println("Hello, " + names.get(i) + "!");
        }

        String day = MONDAY;

        String result = "";
        switch (day) {
            case MONDAY:
                result = "Have a good start of the workweek!";
                break;
            case FRIDAY:
                result = "FriYay!";
                break;
            case SATURDAY:
                result = "Enjoy your weekend!";
                break;
        }

        System.out.println(result);

        var person = new Person("John Doe", "100 Linda Ln.");

        System.out.println(person);

        var secondPerson = new Person("John Doe", "100 Linda Ln.");
        var thirdPerson = new Person("Jane Doe", "100 Linda Ln.");

        if (person.equals(secondPerson)) {
            System.out.println(person.getName() + " and " + secondPerson.getName() + " are the same person."); // Accessor
                                                                                                               // methods
                                                                                                               // are
                                                                                                               // getName()
                                                                                                               // and
                                                                                                               // address()
        }

        if (!person.equals(thirdPerson)) {
            System.out.println(person.getName() + " and " + thirdPerson.getName() + " are not the same person.");
        }
    }
}
