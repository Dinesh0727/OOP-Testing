import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LambdaExpressions {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Inheritance", "Polymorphism", "Charlie");

		// Using lambda expression
		names.forEach(name -> System.out.println(name));
		
		Collections.sort(names, (name1, name2) -> name1.compareTo(name2));

        // Printing sorted names
        names.forEach(System.out::println);
	}
}

