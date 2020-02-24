package java8.streams;

import java.util.Arrays;
import java.util.List;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
          new Person("charles", "Dickens", 34),
          new Person("Lewis", "Carroll", 45),
          new Person("Thomas", "Carylyl", 67),
          new Person("Charlottee", "Branttee", 89),
          new Person("MAthew", "Arnold", 45)
        );

        people.stream().forEach(person -> System.out.println(person.getName()));
        System.out.println("==================================================");
        people.stream().filter(person -> person.getName().startsWith("C"))
                .forEach(person -> System.out.println(person.getName()));
        System.out.println(people.stream()
                .filter(person -> person.getTitle().startsWith("C"))
                .count());
    }
}
