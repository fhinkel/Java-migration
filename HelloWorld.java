import java.util.ArrayList;
import java.util.List;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        // for (String name : names) {
        //     System.out.println("Hello, " + name + "!");
        // }

        for (int i = 0; i < names.size(); i++) {
            System.out.println("Hello, " + names.get(i)+ "!");
        }

    }
}
