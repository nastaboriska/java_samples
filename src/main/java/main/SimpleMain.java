package main;

import java.util.regex.Pattern;
import java.util.stream.Stream;

public class SimpleMain {
  public static void main(String... args) {
    Stream.of("fire", "u", "filter", "fun", "item")
        .flatMap(word -> Stream.of(word.length()) //get stream of word sequence
            .filter(characters -> characters > 1) // forget the length, now check the first symbol
            .map(characters -> word.charAt(0))
            .filter(character -> character == 'f')
            .map(character -> word)) // forget the first symbol, reverting to the whole string
        .forEach(System.out::println);

    String names = "Hello,By,Goodbye,Kokoko";
    boolean result = Pattern.compile(",")
        .splitAsStream(names)
        .anyMatch(name -> name.equals("Hello"));
  }
}
