package main;

import domain.city.City;
import domain.city.House;
import domain.city.Street;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CityMain {

  public static void main(String... args){

    House house1 = new House(1);
    House house2 = new House(2);
    House house3 = new House(3);
    House house4 = new House(4);
    House house5 = new House(5);
    House house6 = new House(6);

    List<House> cityhouses = new ArrayList<House>();
    cityhouses.add(house1);
    cityhouses.add(house2);
    cityhouses.add(house3);
    cityhouses.add(house4);
    cityhouses.add(house5);
    cityhouses.add(house6);

    Street street1 = new Street("Lenina", cityhouses);
    Street street2 = new Street("Ivanova", cityhouses);
    Street street3 = new Street("Nezavisimosti", cityhouses);

    List<Street> streets = new ArrayList<Street>();
    streets.add(street1);
    streets.add(street2);
    streets.add(street3);

    City city1 = new City("NewYork", streets);
    City city2 = new City("London", streets);
    City city3 = new City("Laris", streets);
    City city4 = new City("Linovka", streets);
    //City city4 = new City(null, streets);

    List<City> cities = new ArrayList<City>();
    cities.add(city1);
    cities.add(city2);
    cities.add(city3);
    cities.add(city4);

    //--------------------------------------------
    // Get List of houses.
    // Houses size on the street should be more than 3
    List<House> cityHouses = cities.stream()
        .filter(Objects::nonNull)
        .filter(city -> city.getName().startsWith("L"))
        .flatMap(city -> city.getStreets().stream())
        .map(Street::getHouses)
        .filter(houses -> houses.size() > 3)
        .flatMap(List::stream)
        .collect(Collectors.toList());

    // Get List of houses.
    // Houses size on the street should be more than 3,
    // House number < 6
    List<City> cityList =
        cities.stream().filter(Objects::nonNull)
        .filter(city -> city.getName().startsWith("L"))
        .filter(CityMain::filter)
        .collect(Collectors.toList());

    //SORTING by Street Name, Ignore word case
    streets.stream().sorted(Comparator.comparing(Street::getName, String.CASE_INSENSITIVE_ORDER).reversed()).forEach(System.out::println);

    //FIND MAX
    Street streetWithMaxHouses = streets.stream()
        .max(Comparator.comparing(street -> street.getHouses().size()))
        .orElseThrow(NoSuchElementException::new);

    streets.stream()
        .map(street -> street.getHouses().size())
        .mapToInt(street -> street)
        .average()
        .ifPresent(avg -> System.out.println("Average found is " + avg));

    //Use-cases of IntSummaryStatistics
    IntSummaryStatistics statistics = IntStream.of(51,22,50,27,35).
        collect(IntSummaryStatistics::new, IntSummaryStatistics::accept,
            IntSummaryStatistics::combine);
    System.out.println("Max: "+statistics.getMax()+", Min: "+statistics.getMin());
    System.out.println("Count: "+statistics.getCount()+", statistics: "+statistics.getSum());
    System.out.println("Average: "+statistics.getAverage());
  }

  public static boolean filter(City city){
    return city.getStreets().stream()
            .map(Street::getHouses)
            .filter(houses -> houses.size() > 3)
            .flatMap(List::stream)
        .allMatch(house -> house.getNumber() < 6);
  }
}
