package main;

import domain.book.Section;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;

public class SectionMain {
  public static void main(String... args) {
    Section section1 = new Section(7, new ArrayList<>(Arrays.asList("A", "C", "B")));
    Section section2 = new Section(15, new ArrayList<>(Arrays.asList("A", "C", "B")));
    Section section3 = new Section(20, new ArrayList<>(Arrays.asList("F", "A", "C", "B")));
    Section section4 = new Section(25, new ArrayList<>(Arrays.asList("F", "A", "C", "B")));
    Section section5 = new Section(7, new ArrayList<>(Arrays.asList("F", "A", "C", "B")));

    List<Section> sections = new ArrayList<>();
    sections.add(section1);
    sections.add(section2);
    sections.add(section3);
    sections.add(section4);
    sections.add(section5);

    sections.stream()
        .sorted(comparing(Section::getPageNumber))
        .map(section -> section.getSectionName().stream()
         .sorted(String::compareTo)
            .map(s -> section)
            .distinct()
            .collect(Collectors.groupingBy(Section::getPageNumber)))
        .forEach(System.out::println);
  }
}
