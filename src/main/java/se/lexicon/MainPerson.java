package se.lexicon;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class MainPerson {

    public static void main(String[] args){
        List<Person> people = new ArrayList<>(List.of(
                new Person("Amina", 22, "Stockholm", true),
                new Person("Erik", 17, "Uppsala", true),
                new Person("Noah", 34, "Stockholm", false),
                new Person("Sara", 29, "Gothenburg", true),
                new Person("Lina", 41, "Malmö", false),
                new Person("Omar", 19, "Stockholm", true)
        ));
        PersonProcessor processor = new PersonProcessor();
        System.out.println("----- Active People -----");
        processor.findPeople(people, Person::isActive).forEach(System.out::println);

        System.out.println("----- Adults -----");
        processor.findPeople(people, person -> person.getAge() >= 18).forEach(System.out::println);

        System.out.println("----- People living in Stockholm -----");
        processor.findPeople(people, person -> person.getCity().equalsIgnoreCase("Stockholm")).forEach(System.out::println);

        System.out.println("----- Active Adults -----");
        processor.findPeople(people, person -> person.isActive() && person.getAge() >= 18)
                .forEach(System.out::println);

        //map all people names to uppercase
        System.out.println("----- People Names in Uppercase -----");
        processor.applyToMatching(people, person -> true, person -> person.getName().toUpperCase());

        System.out.println("----- People mapped and sorted by Name in Uppercase -----");
        people.stream().map(Person::getName).map(String::toUpperCase).sorted().forEach(System.out::println);

        int adult = (int) people.stream().filter(person -> person.getAge()>=18)
                .count();

        System.out.println("Number of adults: " + adult);

        people.sort(Comparator.comparingInt(Person::getAge));
        System.out.println("----- People sorted by Age -----");
        people.forEach(System.out::println);

        Optional<Person>  firstActivePerson = Optional.ofNullable(processor.findPeople(people, Person::isActive).get(0));
        System.out.println("----- First Active Person -----");
        firstActivePerson.ifPresent(System.out::println);

        System.out.println("------Multiple filters: Active Adults -------");
        processor.findPeople(people,
                person -> person.isActive() && person.getAge() >= 18)
                .forEach(System.out::println);

        System.out.println("------ Active people in Stockholm -------");
        processor.findPeople(people,
                person -> person.isActive() && person.getCity().equalsIgnoreCase("Stockholm"))
                .forEach(System.out::println);

        System.out.println("------ Inactive people older than 30 -------");
        processor.findPeople(people,
                person -> !person.isActive() && person.getAge() > 30)
                .forEach(System.out::println);

        System.out.println("--------Sorted List of unique cities--------");
        people.stream().map(Person::getCity).distinct().sorted().forEach(System.out::println);

        System.out.println("--------Sorted List of unique first letters of names ------");
        people.stream().map(person -> person.getName().substring(0,1)).distinct()
                .sorted().forEach(System.out::println);

        System.out.println("-------- Mapping and Formating ---------");
        System.out.println("------ List of People with formatted string -------");
        people.stream()
                .map(person -> String.format("Name: %s, Age: %d, City: %s, Active: %b",
                        person.getName(), person.getAge(), person.getCity(), person.isActive()))
                .forEach(System.out::println);

        System.out.println("------ List of Email addresses -------");
        people.stream()
                .map(person -> person.getName().toLowerCase() + "@example.com")
                .forEach(System.out::println);


    }
}
