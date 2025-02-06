import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        var names = new ArrayList<String>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");

        for (var name : names) {
            System.out.println("Hello, " + name + "!");
        }

        var day = today();
        System.out.println("Today is " + day);

        var result = switch (day) {
            case "MONDAY" -> "Have a good start of the workweek!";
            case "WEDNESDAY" -> "Hump day, working towards the weekend.";
            case "FRIDAY" -> "FriYay!";
            case "SATURDAY" -> "Enjoy your weekend!";
            default -> "It's a normal day, " + day + ".";
        };

        System.out.println(result);

        // Use record (Java 14+)
        record Person(String name, String address) {}  // No need for the separate Person class anymore

        var person = new Person("John Doe", "100 Linda Ln.");

        System.out.println(person);

        var secondPerson = new Person("John Doe", "100 Linda Ln.");
        var thirdPerson = new Person("Jane Doe", "100 Linda Ln.");

        if (person.equals(secondPerson)) {
            System.out.println(person.name() + " and " + secondPerson.name() + " are the same person."); // Accessor methods are name() and address()
        }

        if (!person.equals(thirdPerson)) {
            System.out.println(person.name() + " and " + thirdPerson.name() + " are not the same person.");
        }
    }

    private static String today() {
        LocalDate today = LocalDate.now();
        return today.getDayOfWeek().toString();
    }
}
