package java8;

import javax.swing.text.html.Option;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String[] words = {"A", "B", "C", "", ""};

        String[] strArray = new String[10];

        //String word = words[5].toLowerCase();
        //System.out.println(word);

        /**
         * Above code throws null pointer exception
         * Handling Null Pointer using Optional class of java8 java.util package
         */

        System.out.println(Optional.ofNullable(strArray[3]));
        System.out.println(Optional.ofNullable(words[3]).get());
        System.out.println(Optional.of(words[2]).equals("C") ? "Yes" : "NO");

        /**
         * 1. Optional<T> basics example
         */

        System.out.println("--------------------------------------------------------------------------------------");
        Optional<String> gender = Optional.of("Male");
        String answer1 = "YES";
        String answer2 = null;

        System.out.println("Non Empty Optional: " + gender);
        System.out.println("Non Empty Optional: Gender Value: " + gender.get());
        System.out.println("EMPTY OPTIONAL:  " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: "+Optional.ofNullable(answer1));
        System.out.println("ofNullable on Empty Optional: "+Optional.ofNullable(answer2));

        //java.lang.NullPointerException
        //System.out.println("ofNullable on Empty Optional: "+Optional.of(answer2));

        /**
         * 2. Optional.Map and flatMap
         *
         * \u001B[1m ---> used to print anything in bold.
         */

        System.out.println("-----------------\u001B[1m<Optional.Map and flatMap>--------------------------");

        Optional<String> nonEmptyGender = Optional.of("male");
        Optional<String> emptyGender = Optional.empty();

        System.out.println("Non-Empty Optional :: " + nonEmptyGender.map(String::toUpperCase));
        System.out.println("Empty Optional :: " + emptyGender.map(String::toUpperCase));

        Optional<Optional<String>> nonEmptyOptionalGender = Optional.of(Optional.of("male"));

        System.out.println("Optional Value :: " + nonEmptyOptionalGender);
        System.out.println("Optional.map :: " + nonEmptyOptionalGender.map(gender1 -> gender1.map(String::toUpperCase)));
        System.out.println("Optional Value :: " + nonEmptyOptionalGender.flatMap(gender1 -> gender1.map(String::toUpperCase)));
        System.out.println("Optional Value :: Optional.of(<Value>).get(): " + nonEmptyOptionalGender.get());

        /**
         * Optional.filter
         */

        Optional<String> genderNonEmpty = Optional.of("MALE");
        Optional<String> genderEmpty = Optional.empty();

        System.out.println(genderNonEmpty.filter(gender2 -> gender2.equals("male"))); //Optional.empty()
        System.out.println(genderNonEmpty.filter(gender2 -> gender2.equalsIgnoreCase("male"))); //Optional[MALE]
        System.out.println(genderEmpty.filter(gender2 -> gender2.equals("MALE"))); //Optional.empty()

    }
}
