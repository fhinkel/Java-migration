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

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");
        names.add("Eve");


        // for (String name : names) {
        // System.out.println("Hello, " + name + "!");
        // }

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
    }
}
