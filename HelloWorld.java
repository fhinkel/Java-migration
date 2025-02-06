import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    private static final String MONDAY = "Monday";
    private static final String TUESDAY = "Tuesday";
    private static final String WEDNESDAY = "Wednesday";
    private static final String THURSDAY = "Thursday";
    private static final String FRIDAY = "Friday";
    private static final String SATURDAY = "Saturday";
    private static final String SUNDAY = "Sunday";

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        var names = new ArrayList<String>(); // var
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");

        // Enhanced for loop (more idiomatic, even though not a Java 21 specific change)
        for (var name : names) {       // var makes sense here
            System.out.println("Hello, " + name + "!");
        }


        var day = MONDAY;             // var

        // Enhanced switch (Java 14+, preferred style)
        var result = switch (day) {   // var
            case MONDAY -> "Have a good start of the workweek!";
            case FRIDAY -> "FriYay!";
            case SATURDAY -> "Enjoy your weekend!";
            default -> ""; // Always have a default branch or exhaustive cases
        };

        System.out.println(result);
    }
}
